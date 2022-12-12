package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionnaireResponseDto;
import com.epam.team1.emotional.help.model.Questionnaire;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionnaireMapper {
    @Autowired
    private final QuestionMapper questionMapper;

    public QuestionnaireResponseDto mapToResponseDto(Questionnaire questionnaire) {
        log.info("Call of QuestionnaireMapper.mapToResponseDto method. Params: questionnaire {}", questionnaire);
        QuestionnaireResponseDto questionnaireResponseDTO = new QuestionnaireResponseDto();
        questionnaireResponseDTO.setId(questionnaire.getId());
        questionnaireResponseDTO.setName(questionnaire.getName());
        questionnaireResponseDTO.setDescription(questionnaire.getDescription());
        questionnaireResponseDTO.setQuestions(questionMapper.toQuestionResponseDtoList(questionnaire.getQuestionList()));
        return questionnaireResponseDTO;
    }
}
