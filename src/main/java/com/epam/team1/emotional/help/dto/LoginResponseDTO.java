package com.epam.team1.emotional.help.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    private String jwtAccess;
    private String jwtRefresh;
    private UserResponseDTO userResponseDTO;

}