package com.epam.team1.emotional.help.controller;


import com.epam.team1.emotional.help.dto.request.UserAdditionalDataRequestDto;
import com.epam.team1.emotional.help.dto.response.UserResponseDTO;
import com.epam.team1.emotional.help.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add-data")
    public UserResponseDTO addData(@RequestBody UserAdditionalDataRequestDto userAdditionalDataRequestDto) {
        UserResponseDTO userResponseDTO = userService.addData(userAdditionalDataRequestDto);
        return userResponseDTO;
    }
}
