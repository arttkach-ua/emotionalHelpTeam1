package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.dto.response.QuestionResponseDto;
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
