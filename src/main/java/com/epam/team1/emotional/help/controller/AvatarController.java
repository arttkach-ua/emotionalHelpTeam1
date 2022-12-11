package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.MessageResponse;
import com.epam.team1.emotional.help.service.AvatarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/avatars")
@CrossOrigin
public class AvatarController {

    private final AvatarService avatarService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse save(@RequestParam("avatar") MultipartFile avatar) {
        log.info("user requests add avatar " + avatar.getOriginalFilename());
        return avatarService.save(avatar);
    }

    @GetMapping(value = "/{avatar-name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getAvatar(@PathVariable("avatar-name") String avatarName) throws IOException {
        Resource avatar = avatarService.loadAsResource(avatarName);
        return avatar.getInputStream().readAllBytes();
    }

}
