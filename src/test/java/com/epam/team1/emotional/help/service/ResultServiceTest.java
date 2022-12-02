package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultServiceTest {
    @Autowired
    private ResultService resultService;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Test
    void getResult() {
        //Questionnaire questionnaire = questionnaireService.getById(1L);
//        Result result = resultService.getResultByQuestionnaireAndPoints(questionnaire,7);
//        assertEquals("short_desc1",result.getShortDescription());
//        result = resultService.getResultByQuestionnaireAndPoints(questionnaire,8);
//        assertEquals("short_desc2",result.getShortDescription());

    }
}