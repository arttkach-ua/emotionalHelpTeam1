package com.epam.team1.emotional.help.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionnaireResponseDto {

    private Long id;
    private String name;
    private String description;
    private List<QuestionResponseDto> questions;
}
