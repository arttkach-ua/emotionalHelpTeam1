package com.epam.team1.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultResponseDto {
    private Long id;
    private Long questionnaireId;
    private Integer points;
    private String shortDescription;
    private String fullDescription;
}
