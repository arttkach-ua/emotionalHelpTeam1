package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuestionRequestDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public QuestionResponseDto createQuestion(@RequestBody QuestionRequestDto dto){
        return questionService.create(dto);
    }
}