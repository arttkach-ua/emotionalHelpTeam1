package com.epam.team1.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionResponseDto {
    private Long id;
    private String name;
    private List<AnswerResponseDTO> answers;
}
