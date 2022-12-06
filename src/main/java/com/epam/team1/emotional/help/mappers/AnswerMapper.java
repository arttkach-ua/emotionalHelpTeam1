package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.AnswerResponseDto;
import com.epam.team1.emotional.help.model.Answer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerMapper {

    public AnswerResponseDto mapToResponseDto(Answer answer){
        AnswerResponseDto answerResponseDTO = new AnswerResponseDto();
        answerResponseDTO.setId(answer.getId());
        answerResponseDTO.setName(answer.getName());

        return answerResponseDTO;
    }
    public List<AnswerResponseDto> toAnswerResponseDtoList(List<Answer> answers) {
        return answers.stream()
                .map(this::mapToResponseDto)
                .toList();
    }
}