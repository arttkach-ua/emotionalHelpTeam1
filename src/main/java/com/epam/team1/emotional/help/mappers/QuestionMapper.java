package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.response.AnswerResponseDto;
import com.epam.team1.emotional.help.dto.response.QuestionResponseDto;
import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public QuestionMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public QuestionResponseDto mapToResponseDto(Question question) {
        QuestionResponseDto questionResponseDTO = new QuestionResponseDto();
        questionResponseDTO.setId(question.getId());
        questionResponseDTO.setName(question.getName());
        questionResponseDTO.setAnswers(mapAll(question.getAnswersList()));
        return questionResponseDTO;
    }

    private List<AnswerResponseDto> mapAll(List<Answer> answers) {
        return answers.stream().map(answerMapper::mapToResponseDto).collect(Collectors.toList());
    }


}