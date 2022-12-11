package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.quizHistory.QuizHistoryResponseDto;
import com.epam.team1.emotional.help.service.QuizHistoryService;
import com.epam.team1.emotional.help.dto.UserAddDataRequestDto;
import com.epam.team1.emotional.help.dto.UserResponseDTO;

import com.epam.team1.emotional.help.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;


    @Autowired
    private QuizHistoryService quizHistoryService;

    @GetMapping("/{id}/history")
    public List<QuizHistoryResponseDto> getQuizHistoryByUser(@PathVariable("id") Long userId){
        return quizHistoryService.getQuizHistoryByUser(userId);
    }

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
