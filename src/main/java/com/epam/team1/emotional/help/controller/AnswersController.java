package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswersController {
    @Autowired
    AnswersService answersService;

    @PostMapping
    String createAnswer(){
        //Todo create post processing
        return "aaa";
    }
}
