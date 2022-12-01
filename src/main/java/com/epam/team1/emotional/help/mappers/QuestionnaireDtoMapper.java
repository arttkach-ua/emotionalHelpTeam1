package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionnaireDtoMapper {

    public QuestionnaireDto toDTO(Questionnaire questionnaire){
        return QuestionnaireDto.builder()
                .id(questionnaire.getId())
                .name(questionnaire.getName())
                .description(questionnaire.getDescription())
                .build();
    }

    public Questionnaire fromDto(QuestionnaireDto dto){
        return Questionnaire.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

    }
}
