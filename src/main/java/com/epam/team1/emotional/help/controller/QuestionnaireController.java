package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.service.Impl.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/{questionnaire_id}")
    private Questionnaire getById(@PathVariable Long questionnaire_id){
       return questionnaireService.getById(questionnaire_id);
    }

}
