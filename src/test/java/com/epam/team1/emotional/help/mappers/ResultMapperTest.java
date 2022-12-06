package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.request.ResultRequestDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import com.epam.team1.emotional.help.repository.ResultRepository;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ResultMapperTest {

    @MockBean
    QuestionnaireService questionnaireService;

    @Test
    void resultDtoToResult() {
//        //Given
//        ResultRequestDto dto = ResultRequestDto.builder()
//                .questionnaireId(1L)
//                .points(2)
//                .shortDescription("short description")
//                .fullDescription("full description")
//                .build();
//        Questionnaire questionnaire = Questionnaire.builder()
//                .id(1L)
//                .name("test")
//                .description("description")
//                .build();
//        //When
//
//        when(questionnaireService.getById(1L)).thenReturn(questionnaire);
//        //Then
//        Result res = ResultMapper.INSTANCE.resultDtoToResult( dto );
//
//        //then
//        assertThat( res ).isNotNull();
//        assertThat( res.getQuestionnaire() ).isEqualTo( questionnaire );
//        assertThat( res.getFullDescription() ).isEqualTo( "full description" );
//        assertThat( res.getShortDescription() ).isEqualTo( "short description" );
    }
}