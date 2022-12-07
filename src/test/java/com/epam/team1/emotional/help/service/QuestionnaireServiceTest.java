//package com.epam.team1.emotional.help.service;
//
//
//import com.epam.team1.emotional.help.providers.TestDataProvider;
//import com.epam.team1.emotional.help.dto.QuestionnaireDto;
//import com.epam.team1.emotional.help.model.Questionnaire;
//import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class QuestionnaireServiceTest {
//
//    @Autowired
//    private QuestionnaireService questionnaireService;
//
//    @MockBean
//    private QuestionnaireRepository mockedQuestionnaireRepository;
//
//    @Test
//    void testFindAll() {
//        List<Questionnaire> tests = TestDataProvider.getQuestionnairesForTests();
//        when(mockedQuestionnaireRepository.findAll())
//                .thenReturn(tests);
//
//        List<Questionnaire> result = questionnaireService.findAll();
//
//        assertEquals(tests,result);
//        verify(mockedQuestionnaireRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testCreateShouldPassCorrectly() {
//        QuestionnaireDto dto = QuestionnaireDto.builder()
//                .name("test1")
//                .description("desk1")
//                .build();
//        Questionnaire questionnaire = Questionnaire.builder()
//                .id(1L)
//                .name("test1")
//                .description("desk1")
//                .build();
//
//        when(mockedQuestionnaireRepository.save(any(Questionnaire.class)))
//                .thenReturn(questionnaire);
//        QuestionnaireDto result = questionnaireService.create(dto);
//
//        assertEquals("desk1",result.getDescription());
//        assertEquals("test1",result.getName());
//        assertEquals(1L,result.getId());
//        verify(mockedQuestionnaireRepository,times(1))
//                .save(any(Questionnaire.class));
//    }
//
//    @Test
//    void testFindAllDtoRepoIsEmpty() {
//        when(mockedQuestionnaireRepository.findAll())
//                .thenReturn(new ArrayList<Questionnaire>());
//        List<QuestionnaireDto> dtoList = questionnaireService.findAllDto();
//        assertEquals(0, dtoList.size());
//    }
//
//    @Test
//    void testFindAllDtoRepoHasData() {
//        List<Questionnaire> questionnaireList = TestDataProvider.getQuestionnairesForTests();
//        when(mockedQuestionnaireRepository.findAll())
//                .thenReturn(questionnaireList);
//
//        List<QuestionnaireDto> dtoList = questionnaireService.findAllDto();
//        assertEquals("test1", dtoList.get(0).getName());
//        assertEquals("test2", dtoList.get(1).getName());
//        assertEquals(2, dtoList.size());
//    }
//
//    @Test
//    void testGetByIdEntityIsFound() {
//        Questionnaire testQuestionnaire = TestDataProvider.getSingleQuestionnaireForTests();
//        when(mockedQuestionnaireRepository.findById(any(Long.class)))
//                .thenReturn(Optional.of(testQuestionnaire));
//
//        Questionnaire result = questionnaireService.getById(1L);
//        assertEquals("test1", result.getName());
//        assertEquals("desk1", result.getDescription());
//        assertEquals(1L, result.getId());
//    }
//
//    @Test
//    void testGetByIdEntityNotFound() {
//        when(mockedQuestionnaireRepository.findById(anyLong()))
//                .thenReturn(Optional.empty());
//
//        Exception ex = assertThrows(EntityNotFoundException.class,()->questionnaireService.getById(1L));
//        assertEquals("Questionnaire with id 1 not found", ex.getMessage());
//    }
//}