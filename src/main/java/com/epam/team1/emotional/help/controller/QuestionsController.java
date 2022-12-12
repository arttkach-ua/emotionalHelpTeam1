package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuestionRequestDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionResponseDto createQuestion(@Valid @RequestBody QuestionRequestDto dto){
        log.info("Call of /questions endpoint.(Get method).");
        return questionService.create(dto);
    }
}