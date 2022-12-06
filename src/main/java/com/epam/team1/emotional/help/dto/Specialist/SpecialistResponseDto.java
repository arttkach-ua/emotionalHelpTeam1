package com.epam.team1.emotional.help.dto.Specialist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialistResponseDto {
    private Long id;
    private String name;
    private String info;
    private String image;
}
