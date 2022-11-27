package com.epam.team1.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionResponseDto {
    long id;
    String name;
    List<AnswerResponseDTO> answers;
}
