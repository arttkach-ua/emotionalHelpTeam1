package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.validation.annotation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PasswordResetRequest {
    @NotBlank(message = "Please provide your password")
    private String currentPassword;
    @ValidPassword
    private String newPassword;
    @ValidPassword
    private String conformNewPassword;
}
