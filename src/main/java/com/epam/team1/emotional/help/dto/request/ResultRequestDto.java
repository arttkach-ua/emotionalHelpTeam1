package com.epam.team1.emotional.help.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultRequestDto {
    private Long questionnaireId;
    private Integer points;
    private String shortDescription;
    private String fullDescription;
}
