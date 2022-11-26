package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.AnswerResponseDTO;
import com.epam.team1.emotional.help.dto.QuestionResponseDTO;
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

    public QuestionResponseDTO mapToResponseDto(Question question) {
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(question.getId());
        questionResponseDTO.setQuestion(question.getQuestion());
        questionResponseDTO.setAnswers(mapAll(question.getAnswersList()));
        return questionResponseDTO;
    }

    private List<AnswerResponseDTO> mapAll(List<Answer> answers) {
        return answers.stream().map(answerMapper::mapToResponseDto).collect(Collectors.toList());
    }


}