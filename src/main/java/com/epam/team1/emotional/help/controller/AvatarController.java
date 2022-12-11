package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.service.AvatarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{user_id}/avatars")
@CrossOrigin
public class AvatarController {

    String s = File.separator;
    String packagePath = "C:"+s+"Users"+s+"Arthur_Khachatryan"+s+"hhhh";


    @Autowired
    AvatarService avatarService;

    @PostMapping
    public void save(@PathVariable(name = "user_id") Long userId, @RequestParam("avatar") MultipartFile avatar) throws IOException {
        log.info("user with id " + userId + " requests add avatar " + avatar.getOriginalFilename());
        avatarService.save(userId, avatar);
    }


    @GetMapping(value = "/{filename}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getAvatar(@PathVariable String filename) throws IOException {

        Resource file = avatarService.loadAsResource(filename);
        return file.getInputStream().readAllBytes();

//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + file.getFilename() + "\"").body(file);

    }

//    @GetMapping(value = "/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public @ResponseBody byte[] getImageWithMediaType(@PathVariable String name) throws IOException {
//        String fullname = packagePath + s + name;
//        File file = new File(fullname);
//        File file2 = new File(packagePath);
//
//        System.out.println("fullname " + file.canWrite() + file.canRead());
//        System.out.println("fullname " + file2.canWrite() + file.canRead());
//        System.out.println("fullname " + fullname);
//        System.out.println("fullname " + fullname);
//        log.info("kkkkkkkk");
//        log.info("kkkkkkkk");
//        log.info("kkkkkkkk");
//        log.info("kkkkkkkk");
//
//        InputStream in = getClass()
//                .getResourceAsStream(fullname);
//        return IOUtils.toByteArray(in);
//    }



}
