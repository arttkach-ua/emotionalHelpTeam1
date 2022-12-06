package com.epam.team1.emotional.help.dto.request;

import com.epam.team1.emotional.help.validation.annotation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PasswordResetRequest {
    @NotBlank(message = "Please provide your password")
    String currentPassword;
    @ValidPassword
    String newPassword;
    @ValidPassword
    String conformNewPassword;
}
