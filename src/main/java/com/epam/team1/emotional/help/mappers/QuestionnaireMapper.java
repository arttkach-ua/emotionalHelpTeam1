package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionResponseDTO;
import com.epam.team1.emotional.help.dto.QuestionnaireResponseDTO;
import com.epam.team1.emotional.help.model.Questionnaire;
import org.springframework.stereotype.Component;

@Component
public class QuestionnaireMapper {

    public QuestionnaireResponseDTO mapToResponseDto(Questionnaire questionnaire) {

        QuestionnaireResponseDTO questionnaireResponseDTO = new QuestionnaireResponseDTO();
        questionnaireResponseDTO.setId(questionnaire.getId());
        questionnaireResponseDTO.setName(questionnaire.getName());
        questionnaireResponseDTO.setDescription(questionnaire.getDescription());
        //questionnaireResponseDTO.setQuestionResponseDTOList();
        return questionnaireResponseDTO;
    }
}
