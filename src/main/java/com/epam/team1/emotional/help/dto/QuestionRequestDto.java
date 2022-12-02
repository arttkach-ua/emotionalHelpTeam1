package com.epam.team1.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionRequestDto {
    private Long questionnaireId;
    private String name;
}
