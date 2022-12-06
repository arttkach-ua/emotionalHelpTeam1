package com.epam.team1.emotional.help.controller;


import com.epam.team1.emotional.help.dto.response.SignupResponseDTO;
import com.epam.team1.emotional.help.mappers.SignupMapper;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.dto.request.SignupUserRequestDTO;
import com.epam.team1.emotional.help.dto.response.MessageResponse;
import com.epam.team1.emotional.help.exception.EmailAlreadyExistsException;
import com.epam.team1.emotional.help.service.SignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
@CrossOrigin
public class SignupController {

    private final SignupService signupService;
    private final SignupMapper signupMapper;

    @PostMapping("/user")
    public @ResponseStatus(HttpStatus.CREATED) SignupResponseDTO registerUser(@Valid @RequestBody SignupUserRequestDTO signupUserRequestDTO) {
        User savedUser = signupService.saveUser(signupUserRequestDTO);
        log.error("new user is registered " + signupUserRequestDTO);
        return signupMapper.mapToResponseDto(savedUser);
    }

    @GetMapping("/confirm-email/{code}")
    public MessageResponse confirmEmail(@PathVariable("code") String code) {
        MessageResponse messageResponse = signupService.confirmEmail(code);
        log.error("email is conformed with code " + code);
        return messageResponse;
    }

}
