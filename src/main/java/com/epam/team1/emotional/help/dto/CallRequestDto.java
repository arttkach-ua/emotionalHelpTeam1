package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.util.ValidationMessages;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class CallRequestDto {
    @NotNull(message = ValidationMessages.NULL_NAME)
    @Size(min = 2, message = ValidationMessages.NAME_TOO_SHORT)
    @Size(max=50, message = ValidationMessages.NAME_TOO_LONG)
    private String name;
    @NotNull(message = ValidationMessages.NULL_PHONE_NUMBER)
    @Size(min = 2, message = ValidationMessages.PHONE_NUMBER_TOO_SHORT)
    private String phoneNumber;
}
