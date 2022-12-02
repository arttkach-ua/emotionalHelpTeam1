package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionRequestDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.providers.QuestionDataProvider;
import com.epam.team1.emotional.help.repository.QuestionRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestionServiceTest {
    @Autowired
    private QuestionService questionService;

    @MockBean
    private QuestionRepository questionRepository;

    @MockBean
    private QuestionnaireService questionnaireService;

    @ParameterizedTest
    @ArgumentsSource(QuestionDataProvider.class)
    void createCorrectCase(QuestionRequestDto dto, Question question, Long id, String name) {

        when(questionRepository.save(any(Question.class)))
                .thenReturn(question);

        QuestionResponseDto resultQuestion = assertDoesNotThrow(()->questionService.create(dto));
        assertEquals(id, resultQuestion.getId());
        assertEquals(name, resultQuestion.getName());
    }

//    @ParameterizedTest
//    @MethodSource("com.epam.team1.emotional.help.providers.TestDataProvider#get")
//    void getAllByQuestionnaireId() {
//        when(questionnaireService.getById(anyLong()))
//                .thenReturn(TestDataProvider.getSingleQuestionnaireForTests().get(0));
//        when(questionRepository.findByQuestionnaire(any(Questionnaire.class)))
//                .thenReturn();
//        List<Question> resultQuestions = assertDoesNotThrow(()->questionService.getAllByQuestionnaireId(1L));
//        assertEquals();
//    }
}