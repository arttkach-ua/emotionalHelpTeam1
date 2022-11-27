package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuestionDto;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public Question createQuestion(@RequestBody QuestionDto dto){
        //Todo remake to DTO
        return questionService.create(dto);
    }
}
