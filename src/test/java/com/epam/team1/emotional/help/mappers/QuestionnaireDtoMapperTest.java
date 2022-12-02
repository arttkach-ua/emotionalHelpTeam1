package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class QuestionnaireDtoMapperTest {

    @Autowired
    QuestionnaireDtoMapper mapper;

    @Test
    void toDTO() {
        //given
        Questionnaire questionnaire = Questionnaire.builder()
                .id(1L)
                .name("test")
                .description("description")
                .build();
        //when
        QuestionnaireDto dto = mapper.toDTO(questionnaire);
        //then
        assertThat(dto).isNotNull();
        assertThat(dto.getName()).isEqualTo( "test");
        assertThat(dto.getDescription()).isEqualTo( "description" );
        assertThat(dto.getId()).isEqualTo(1);
    }

    @Test
    void fromDto() {
        //given
        QuestionnaireDto dto = QuestionnaireDto.builder()
                .id(1L)
                .name("test")
                .description("description")
                .build();
        //when
        Questionnaire questionnaire = mapper.fromDto(dto);
        //then
        assertThat(questionnaire).isNotNull();
        assertThat(questionnaire.getName()).isEqualTo( "test");
        assertThat(questionnaire.getDescription()).isEqualTo( "description" );
        assertThat(questionnaire.getId()).isEqualTo(1);
    }
}