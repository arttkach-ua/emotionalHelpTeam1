package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.MessageResponse;
import com.epam.team1.emotional.help.exception.StorageFileNotFoundException;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RequiredArgsConstructor
@Service
public class AvatarService {

    private final UserService userService;

    private final UserRepository userRepository;

    @Value("${path.basePackagePath}")
    private String basePackagePath;

    String pathSeparator = File.separator;

    public MessageResponse save(@NotNull MultipartFile avatar) {
        if (avatar.isEmpty()) {
            throw new RuntimeException("avatar must not be empty");
        }
        User currentUser = userService.getCurrentUser().orElseThrow(() -> new NotFoundException("User not found"));
        String avatarOriginalName = avatar.getOriginalFilename();

        if (currentUser.getImage() != null) {
            File file = new File(basePackagePath + pathSeparator + "user_" + currentUser.getId() + pathSeparator + currentUser.getImage());
            log.info("user current image path is {}" , file);
            file.delete();
        }
        final Path rootPath = Paths.get(basePackagePath);
        Path foolPath;
        try {
            foolPath = rootPath.resolve("user_" + currentUser.getId());
            Files.createDirectories(foolPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
        try {
            Files.copy(avatar.getInputStream(), foolPath.resolve(avatarOriginalName));
            currentUser.setImage(avatarOriginalName);
            log.info("new user image is {}", currentUser.getImage());
            userRepository.save(currentUser);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
        return new MessageResponse(avatarOriginalName);
    }

    public byte[] getAsByteArray(String filename) {
        User currentUser = userService.getCurrentUser().orElseThrow(() -> new NotFoundException("User not found"));
        if (currentUser.getImage() == null) {
            throw new RuntimeException("you can not get your avatar as your avatar has bean deleted or you did not add it yet.");
        } else if (!currentUser.getImage().equals(filename)) {
            throw new RuntimeException("your provided name for user avatar is wrong");
        }
        try {
            Path filePath = Paths.get(basePackagePath).resolve("user_" + currentUser.getId()).resolve(filename);
            log.info("file absolute = {}", filePath.getFileName());
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource.getInputStream().readAllBytes();
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public MessageResponse deleteByName(String avatarName) {
        User currentUser = userService.getCurrentUser().orElseThrow(() -> new NotFoundException("User not found"));
        if (!currentUser.getImage().equals(avatarName)) {
            log.info("request for deleting avatar with avatar name is {}", avatarName);
            throw new RuntimeException("Avatar name is not correct");
        }
        File file = new File(basePackagePath + pathSeparator + "user_" + currentUser.getId() + pathSeparator + avatarName);

        if (!file.exists()) {
            log.error("file does not exists with path {}", file);
            throw new RuntimeException("file dos not exists");
        }
        log.info("file is going to delete = {}", file);

        file.delete();
        currentUser.setImage(null);
        userRepository.save(currentUser);
        return new MessageResponse("avatar is deleted");
    }
}
