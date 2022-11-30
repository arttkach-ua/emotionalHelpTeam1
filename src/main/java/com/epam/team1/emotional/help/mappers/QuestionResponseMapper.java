package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class QuestionResponseMapper {
    @Autowired
    private AnswerMapper answerMapper;

    /**
     * Maps Question entity to QuestionResponseDto
     * @param question
     * @return QuestionResponseDto
     */
    public QuestionResponseDto toDto(Question question){
        return QuestionResponseDto.builder()
                .id(question.getId())
                .name(question.getName())
                .answers(question.getAnswersList().stream()
                        .map(answerMapper::mapToResponseDto)
                        .toList())
                .build();
    }
}
