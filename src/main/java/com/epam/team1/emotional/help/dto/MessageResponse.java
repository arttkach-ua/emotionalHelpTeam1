package com.epam.team1.emotional.help.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageResponse {

    private String message;
    private String token;

    public MessageResponse(String message) {
        this.message = message;
    }

}
