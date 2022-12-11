package com.epam.team1.emotional.help.controller;


import com.epam.team1.emotional.help.dto.UserAddDataRequestDto;
import com.epam.team1.emotional.help.dto.UserResponseDTO;
import com.epam.team1.emotional.help.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable("id") Long id) {
        log.info("request to get user with id " + id);
        return userService.getById(id);
    }


    @PatchMapping("/{id}")
    public UserResponseDTO resetById(@PathVariable("id") Long id, @RequestBody UserAddDataRequestDto userAddDataRequestDto) {
        log.info("request to reset user with id " + id);
        return userService.resetById(id, userAddDataRequestDto);
    }

}
