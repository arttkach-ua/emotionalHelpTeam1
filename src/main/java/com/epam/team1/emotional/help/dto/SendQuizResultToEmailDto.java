package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.util.ValidationMessages;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class SendQuizResultToEmailDto {

    @NotNull(message = ValidationMessages.NULL_NAME)
    @Size(min = 2, message = ValidationMessages.NAME_TOO_SHORT)
    @Size(max = 50, message = ValidationMessages.NAME_TOO_LONG)
    private String name;

    @Email
    @NotNull
    private String email;

    @NotNull(message = ValidationMessages.NULL_NAME)
    @Size(min = 2, message = ValidationMessages.NAME_TOO_SHORT)
    @Size(max = 50, message = ValidationMessages.NAME_TOO_LONG)
    private String description;

    @NotNull
    Integer points;
    @NotNull
    private Long questionnaireId;
}
