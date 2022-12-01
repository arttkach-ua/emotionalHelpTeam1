package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.dto.QuestionnaireResponseDto;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionnaireMapper {

    private final QuestionMapper questionMapper;

    public QuestionnaireResponseDto mapToResponseDto(Questionnaire questionnaire) {
        QuestionnaireResponseDto questionnaireResponseDTO = new QuestionnaireResponseDto();
        questionnaireResponseDTO.setId(questionnaire.getId());
        questionnaireResponseDTO.setName(questionnaire.getName());
        questionnaireResponseDTO.setDescription(questionnaire.getDescription());
        questionnaireResponseDTO.setQuestions(mapAll(questionnaire.getQuestionList()));
        return questionnaireResponseDTO;
    }

    private List<QuestionResponseDto> mapAll(List<Question> questions) {
        return questions.stream()
                .map(questionMapper::toQuestionResponseDto)
                .toList();
    }
}
