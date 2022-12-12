package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class QuestionnaireDtoMapper {

    public QuestionnaireDto toDTO(Questionnaire questionnaire){
        log.info("Call of QuestionnaireDtoMapper.toDTO method. Params: questionnaire {}", questionnaire);
        return QuestionnaireDto.builder()
                .id(questionnaire.getId())
                .name(questionnaire.getName())
                .description(questionnaire.getDescription())
                .build();
    }

    public Questionnaire fromDto(QuestionnaireDto dto){
        log.info("Call of QuestionnaireDtoMapper.fromDto method. Params: dto {}", dto);
        return Questionnaire.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

    }
}
