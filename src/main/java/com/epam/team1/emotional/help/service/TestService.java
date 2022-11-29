package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.TestDto;
import com.epam.team1.emotional.help.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    AnswersService answersService;

    public void calculateTest(TestDto dto){
        Test test = mapTestDtoToTest(dto);
        calculateTotalPoints(test);
        test.setTotalPoints(calculateTotalPoints(test));


    }

    public Test mapTestDtoToTest(TestDto dto){
        Test test = new Test();
        test.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        test.setAnswers(dto.getAnswers().stream()
                .map(a->answersService.getById(a.getAnswerId()))
                .toList());
        return test;
    }

    public Integer calculateTotalPoints(Test test){
        return test.getAnswers().stream()
                .mapToInt(a->a.getPoints())
                .sum();
    }
}
