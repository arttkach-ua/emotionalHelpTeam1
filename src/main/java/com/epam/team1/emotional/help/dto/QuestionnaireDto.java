package com.epam.team1.emotional.help.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionnaireDto {
    long id;
    String name;
    String description;
}
