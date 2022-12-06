package com.epam.team1.emotional.help.dto.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponseDto {
    Long id;
    String title;
    String description;
}
