package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class QuestionResponseMapper {
    @Autowired
    private AnswerMapper answerMapper;

    /**
     * Maps Question entity to QuestionResponseDto
     * @param question
     * @return QuestionResponseDto
     */
    public QuestionResponseDto toQuestionResponseDto(Question question){
        log.info("Call of QuestionResponseMapper.toQuestionResponseDto method. Params: question {}", question);
        return QuestionResponseDto.builder()
                .id(question.getId())
                .name(question.getName())
                .answers(question.getAnswersList().stream()
                        .map(answerMapper::mapToResponseDto)
                        .toList())
                .build();
    }
}
