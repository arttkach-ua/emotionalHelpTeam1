package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.reposithory.QuestionnaireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestionnaireServiceTest {

    @Autowired
    QuestionnaireService questionnaireService;

    @MockBean
    QuestionnaireRepository questionnaireRepository;

    @Test
    void findAll() {
        List<Questionnaire> testList = getQuestionnairesForTests();

        when(questionnaireRepository.findAll())
                .thenReturn(testList);

        List<Questionnaire> result = questionnaireService.findAll();
        assertEquals(testList,result);
        verify(questionnaireRepository, times(1)).findAll();
    }

    private List<Questionnaire> getQuestionnairesForTests(){
        List<Questionnaire> questionnaires = new ArrayList<>();
        questionnaires.add(Questionnaire.builder().id(1).name("test1").description("desk1").build());
        questionnaires.add(Questionnaire.builder().id(2).name("test2").description("desk2").build());
        return questionnaires;
    }

    @Test
    void createShouldPassCorrectly() {
        QuestionnaireDto dto = QuestionnaireDto.builder()
                .name("test1")
                .description("desk1")
                .build();
        Questionnaire questionnaire = Questionnaire.builder()
                .id(1)
                .name("test1")
                .description("desk1")
                .build();

        when(questionnaireRepository.save(any(Questionnaire.class)))
                .thenReturn(questionnaire);
        Questionnaire result = questionnaireService.create(dto);

        assertEquals(questionnaire,result);
        verify(questionnaireRepository,times(1))
                .save(any(Questionnaire.class));
    }
}