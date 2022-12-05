package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuizDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")//Todo rename to ("/completeQuiz")
@CrossOrigin
public class ResultController {
    @PostMapping
    QuizDto calculateResult(@RequestBody QuizDto dto){
        QuizDto quizDto = new QuizDto();
        quizDto.setToken("1");
        quizDto.setQuestionnaireId(1L);
        QuizDto.CompleteAnswer answer = new QuizDto.CompleteAnswer();
        answer.setAnswerId(1L);
        answer.setQuestionId(1L);
        quizDto.setAnswers(List.of(answer));
        return quizDto;
    }
}