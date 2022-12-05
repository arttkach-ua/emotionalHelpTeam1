package com.epam.team1.emotional.help.controller;


import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.dto.request.SignupUserRequestDTO;
import com.epam.team1.emotional.help.dto.response.MessageResponse;
import com.epam.team1.emotional.help.dto.response.UserResponseDTO;
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
public class SignupController {

    private final SignupService signupService;
    private final UserMapper userMapper;


    @PostMapping("/user")
    public @ResponseStatus(HttpStatus.CREATED) UserResponseDTO registerUser(@Valid @RequestBody SignupUserRequestDTO signupUserRequestDTO) {
        System.out.println("SignupController registerUser");
        Optional<User> user = signupService.findByEmail(signupUserRequestDTO.getEmail());
        if (user.isPresent()) {
            throw new EmailAlreadyExistsException("the provided email address already exists");
        }
        User savedUser = signupService.saveUser(signupUserRequestDTO);
        System.out.println("controller registerUser()");
        return userMapper.mapToResponseDto(savedUser);
    }

    @GetMapping("/confirm-email/{code}")
    public MessageResponse confirmEmail(@PathVariable("code") String code) {
        MessageResponse messageResponse = signupService.confirmEmail(code);
        return messageResponse;
    }

}
