package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.providers.TestDataProvider;
import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestionnaireServiceTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @MockBean
    private QuestionnaireRepository questionnaireRepository;

    @Test
    void findAll() {
        List<Questionnaire> tests = TestDataProvider.getQuestionnairesForTests();
        when(questionnaireRepository.findAll())
                .thenReturn(tests);

        List<Questionnaire> result = questionnaireService.findAll();

        assertEquals(tests,result);
        verify(questionnaireRepository, times(1)).findAll();
    }

    @Test
    void createShouldPassCorrectly() {
        QuestionnaireDto dto = QuestionnaireDto.builder()
                .name("test1")
                .description("desk1")
                .build();
        Questionnaire questionnaire = Questionnaire.builder()
                .id(1L)
                .name("test1")
                .description("desk1")
                .build();

        when(questionnaireRepository.save(any(Questionnaire.class)))
                .thenReturn(questionnaire);
        QuestionnaireDto result = questionnaireService.create(dto);

        assertEquals("desk1",result.getDescription());
        assertEquals("test1",result.getName());
        assertEquals(1L,result.getId());
        verify(questionnaireRepository,times(1))
                .save(any(Questionnaire.class));
    }

    @Test
    void findAllDtoRepoIsEmpty() {
        when(questionnaireRepository.findAll())
                .thenReturn(new ArrayList<Questionnaire>());
        List<QuestionnaireDto> dtoList = assertDoesNotThrow(()->questionnaireService.findAllDto());
        assertEquals(0, dtoList.size());
    }

    @Test
    void findAllDtoRepoHasData() {
        List<Questionnaire> questionnaireList = TestDataProvider.getQuestionnairesForTests();
        when(questionnaireRepository.findAll())
                .thenReturn(questionnaireList);

        List<QuestionnaireDto> dtoList = assertDoesNotThrow(()->questionnaireService.findAllDto());
        assertEquals("test1", dtoList.get(0).getName());
        assertEquals("test2", dtoList.get(1).getName());
        assertEquals(2, dtoList.size());
    }

    @Test
    void getByIdEntityIsFound() {
        Questionnaire testQuestionnaire = TestDataProvider.getSingleQuestionnaireForTests();
        when(questionnaireRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(testQuestionnaire));

        Questionnaire result = assertDoesNotThrow(()->questionnaireService.getById(1L));
        assertEquals("test1", result.getName());
        assertEquals("desk1", result.getDescription());
        assertEquals(1L, result.getId());
    }

    @Test
    void getByIdEntityNotFound() {
        when(questionnaireRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        Exception ex = assertThrows(EntityNotFoundException.class,()->questionnaireService.getById(1L));
        assertEquals("Questionnaire with id 1 not found", ex.getMessage());
    }
}