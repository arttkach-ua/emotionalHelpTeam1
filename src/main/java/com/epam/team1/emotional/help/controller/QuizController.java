package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuizDto;
import com.epam.team1.emotional.help.mappers.QuizDtoMapper;
import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    QuizService quizService;
    @Autowired
    QuizDtoMapper quizDtoMapper;

    @GetMapping
    public ResponseEntity<List<QuizDto>> getQuizzes(){
        List<Quiz> quizzes = quizService.findAll();
        List<QuizDto> quizzesDto = quizzes.stream()
                .map(a->quizDtoMapper.toDTO(a))
                .toList();
        return ResponseEntity.ok(quizzesDto);
    }
}
