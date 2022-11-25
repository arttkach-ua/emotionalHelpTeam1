package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionResponseDTO;
import com.epam.team1.emotional.help.model.Question;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public QuestionMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public QuestionResponseDTO mapToResponseDto(Question question) {
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(question.getId());
        questionResponseDTO.setQuestion(question.getQuestion());
        questionResponseDTO.setAnswerResponseDTOList(question.getAnswersList().stream().map(answerMapper::mapToResponseDto).collect(Collectors.toList()));
        return questionResponseDTO;
    }
}