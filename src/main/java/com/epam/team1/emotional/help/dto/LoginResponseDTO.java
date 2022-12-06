package com.epam.team1.emotional.help.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponseDTO {

    private String jwtAccess;
    private String jwtRefresh;
    private UserResponseDTO userResponseDTO;

    public LoginResponseDTO(String jwtAccess, String jwtRefresh, UserResponseDTO mapToResponseDto) {
        this.jwtAccess = jwtAccess;
        this.jwtRefresh = jwtRefresh;
        this.userResponseDTO = getUserResponseDTO();
    }
}
