package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnairesController {
    @Autowired
    QuestionnaireService questionnaireService;

    @GetMapping
    public List<QuestionnaireDto> getQuizzes(){
        return questionnaireService.findAllDto();
    }

    @PostMapping
    public Questionnaire postQuiz(@RequestBody QuestionnaireDto dto){
        return questionnaireService.create(dto);
    }
}
