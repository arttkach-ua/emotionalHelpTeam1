package com.epam.team1.emotional.help.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class QuestionResponseDto {
    private Long id;
    private Long questionnaireId;
    private String name;
    private List<AnswerResponseDto> answers;
}
