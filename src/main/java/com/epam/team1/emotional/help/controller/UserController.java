package com.epam.team1.emotional.help.controller;


import com.epam.team1.emotional.help.dto.request.UserAdditionalDataRequestDto;
import com.epam.team1.emotional.help.dto.response.UserResponseDTO;
import com.epam.team1.emotional.help.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("/add-data")
    public UserResponseDTO addData(@RequestBody UserAdditionalDataRequestDto userAdditionalDataRequestDto) {
        UserResponseDTO userResponseDTO = userService.addData(userAdditionalDataRequestDto);
        return userResponseDTO;
    }
}
