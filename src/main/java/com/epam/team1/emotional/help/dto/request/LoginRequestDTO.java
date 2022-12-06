package com.epam.team1.emotional.help.dto.request;

import com.epam.team1.emotional.help.validation.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LoginRequestDTO {
    @NotBlank
    private String username;
    @ValidPassword
    private String password;

}
