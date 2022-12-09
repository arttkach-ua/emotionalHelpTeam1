package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class ResultMapperTest {

    @MockBean
    private QuestionnaireService questionnaireService;

    @Autowired
    private ResultMapper resultMapper;

    @Test
    void testResultDtoToResult() {
        //Given
        ResultRequestDto dto = ResultRequestDto.builder()
                .questionnaireId(1L)
                .points(2)
                .shortDescription("short description")
                .fullDescription("full description")
                .build();
        Questionnaire questionnaire = Questionnaire.builder()
                .id(1L)
                .name("test")
                .description("description")
                .build();
        //When

        when(questionnaireService.getById(1L)).thenReturn(questionnaire);
        Result res = resultMapper.fromDto(dto);
        //Then

        //then
        assertThat( res.getPoints() ).isEqualTo( 2 );
        assertThat( res.getFullDescription() ).isEqualTo( "full description" );
        assertThat( res.getShortDescription() ).isEqualTo( "short description" );
    }
}