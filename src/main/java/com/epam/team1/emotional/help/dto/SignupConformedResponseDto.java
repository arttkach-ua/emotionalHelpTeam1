package com.epam.team1.emotional.help.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupConformedResponseDto {
    private String token;
    private UserResponseDTO userResponseDTO;

}