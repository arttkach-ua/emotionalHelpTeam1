package com.epam.team1.emotional.help.dto.Specialist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialistRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String info;
    @NotNull
    private String image;
}
