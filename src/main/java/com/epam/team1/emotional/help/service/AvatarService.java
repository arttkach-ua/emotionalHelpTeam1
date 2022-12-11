package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.MessageResponse;
import com.epam.team1.emotional.help.exception.StorageFileNotFoundException;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.File;
import java.net.MalformedURLException;
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

        String avatarOriginalFilename = avatar.getOriginalFilename();
        File file = new File(basePackagePath + pathSeparator + currentUser.getEmail() + pathSeparator + avatarOriginalFilename);

        boolean wasSuccessful = file.mkdirs();
        log.info("directories creation were successful = " + wasSuccessful + " it also can be not cussessfull becouse if it already exists");
        log.info("file absolute = " + file.getAbsoluteFile());
        log.info(" can read and wright  = " + file.canRead() + "" + file.canWrite());
        try {
            avatar.transferTo(file);
            currentUser.setImage(avatarOriginalFilename);
            userRepository.save(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("exception is " + e);
            throw new RuntimeException(e);
        }
        return new MessageResponse(avatarOriginalFilename);
    }

    public Resource loadAsResource(String filename) {
        User currentUser = userService.getCurrentUser().orElseThrow(() -> new NotFoundException("User not found"));
        if (currentUser.getImage() == null) {
            throw new RuntimeException("you can not get your avatar as your avatar has bean deleted or you did not add it yet.");
        } else if (!currentUser.getImage().equals(filename)) {
            throw new RuntimeException("your provided name for user avatar is wrong");

        }
        try {
            Path filePath = Paths.get(basePackagePath).resolve(currentUser.getEmail()).resolve(filename);
            log.info("full name " + filePath);
            log.info("file absolute = " + filePath.getFileName());
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            log.info(e.getLocalizedMessage());
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public void deleteByName(String avatarName) {
        User currentUser = userService.getCurrentUser().orElseThrow(() -> new NotFoundException("User not found"));
        if (!currentUser.getImage().equals(avatarName)) {
            log.info("request for deleting avatar with avatar name is " + avatarName);
            log.info("user image name is " + currentUser.getImage());
            throw new RuntimeException("Avatar name is not correct");
        }
        File file = new File(basePackagePath + pathSeparator + currentUser.getEmail() + pathSeparator + avatarName);

        if (!file.exists()) {
            log.info("file doesnot exists with path " + file);
            throw new RuntimeException("file dos not exists");
        }
        log.info("file is going to delete = " + file);
        file.delete();
        currentUser.setImage(null);
        userRepository.save(currentUser);
    }
}
