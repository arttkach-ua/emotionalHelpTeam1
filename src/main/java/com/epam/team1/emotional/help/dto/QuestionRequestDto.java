package com.epam.team1.emotional.help.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class QuestionRequestDto {
    private Long questionnaireId;
    private String name;
}
