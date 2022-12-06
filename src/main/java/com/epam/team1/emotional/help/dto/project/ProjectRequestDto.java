package com.epam.team1.emotional.help.dto.project;

import com.epam.team1.emotional.help.util.ValidationMessages;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class ProjectRequestDto {
    @NotNull(message = ValidationMessages.NULL_TITLE)
    @Size(min = 5, message = ValidationMessages.TITLE_TOO_SHORT)
    String title;
    @NotNull(message = ValidationMessages.NULL_DESCRIPTION)
    @Size(min = 5, message = ValidationMessages.DESCRIPTION_TOO_SHORT)
    String description;
}
