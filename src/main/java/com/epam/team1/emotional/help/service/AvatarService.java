package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.exception.StorageFileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class AvatarService {

    @Autowired
    UserService userService;

    @Value("${path.uploadPicturePath}")
    private String uploadPicturePath;


    String s = File.separator;
    String packagePath = "C:"+s+"Users"+s+"Arthur_Khachatryan"+s+"hhhh";


    public void save(Long userId, @NotNull MultipartFile avatar) throws IOException {
        if (avatar.isEmpty()) {
            throw new RuntimeException("avatar must not be empty");
        }

        String fileName = avatar.getOriginalFilename();

        File file = new File(packagePath + s + fileName);


        file.mkdirs();
        // System.out.println(file.getAbsoluteFile());
        //System.out.println(file.getCanonicalFile());
        // System.out.println(file.exists());
        // System.out.println("" + file.canRead() + "" + file.canWrite());
        //file.
        try {
            avatar.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Path getAvatar(String filename) {
        Path rootLocation = Paths.get(packagePath);
        return rootLocation.resolve(filename);
    }


    public Resource loadAsResource(String filename) {
        try {
            Path file = getAvatar(filename);
            log.info("full name " + file);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {

                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            System.out.println(e);
            System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            log.info(e.getLocalizedMessage());
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

//    public void save(Long userId, MultipartFile avatar) {
//
//        log.info("root location as path = " + rootLocation);
//
//        try {
//            if (avatar.isEmpty()) {
//                throw new StorageException("Failed to store empty file.");
//            }
//            Path destinationFile = this.rootLocation.resolve(Paths.get(avatar.getOriginalFilename()))
//                    .normalize().toAbsolutePath();
//
//            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
//                // This is a security check
//                throw new StorageException(
//                        "Cannot store file outside current directory.");
//            }
//            try (InputStream inputStream = avatar.getInputStream()) {
//                Files.copy(inputStream, destinationFile,
//                        StandardCopyOption.REPLACE_EXISTING);
//            }
//        } catch (IOException e) {
//            throw new StorageException("Failed to store file.", e);
//        }
//    }


//    public void getAvatar() {
//        Path path = Path.of(rootLocation);
//        return path.resolve();
//
//    }


}
