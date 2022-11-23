package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping
    public List<Quiz> getQuizzes(){
        return quizService.findAll();
    }
}
