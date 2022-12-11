package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.MessageResponse;
import com.epam.team1.emotional.help.service.AvatarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
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
        log.info("user did get avatar request with avatar name " + avatarName);
        return avatarService.getAsByteArray(avatarName);
    }


    @DeleteMapping("/{avatar-name}")
    public void deleteByName(@PathVariable("avatar-name") @NotBlank String avatarName) {
        log.info("user did delete avatar request with avatar name " + avatarName);
        avatarService.deleteByName(avatarName);
    }
}
