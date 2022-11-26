package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.mappers.QuestionnaireMapper;
import com.epam.team1.emotional.help.service.Impl.QuestionnaireService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {
    private QuestionnaireService questionnaireService;
    private QuestionnaireMapper questionnaireMapper;

    public QuestionnaireController(QuestionnaireService questionnaireService, QuestionnaireMapper questionnaireMapper) {
        this.questionnaireService = questionnaireService;
        this.questionnaireMapper = questionnaireMapper;
    }

}
