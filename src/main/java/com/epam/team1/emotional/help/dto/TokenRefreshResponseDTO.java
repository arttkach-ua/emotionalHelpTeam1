package com.epam.team1.emotional.help.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TokenRefreshResponseDTO {
    public TokenRefreshResponseDTO(String jwtAccess, String jwtRefresh) {
        this.jwtAccess = jwtAccess;
        this.jwtRefresh = jwtRefresh;
    }

    private String jwtAccess;
    private String type = "Bearer";
    private String jwtRefresh;

}
