package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
@CrossOrigin
public class AnswersController {
    @Autowired
    private AnswersService answersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    String createAnswer(){
        //Todo create post processing
        return "aaa";
    }
}