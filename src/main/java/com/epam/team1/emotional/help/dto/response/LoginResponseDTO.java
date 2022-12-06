package com.epam.team1.emotional.help.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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
