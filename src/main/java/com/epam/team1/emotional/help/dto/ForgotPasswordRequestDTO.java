package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.validation.annotation.ValidPassword;
import lombok.Data;

@Data
public class ForgotPasswordRequestDTO {
    private String code;
    @ValidPassword
    private String password;
    @ValidPassword
    private String confirmPassword;

}
