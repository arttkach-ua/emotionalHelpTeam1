package com.epam.team1.emotional.help.dto.Specialist;

import com.epam.team1.emotional.help.util.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialistRequestDto {
    @NotNull(message = ValidationMessages.NULL_NAME)
    @Size(min = 2, message = ValidationMessages.NAME_TOO_SHORT)
    private String name;
    @NotNull(message = ValidationMessages.NULL_INFO)
    @Size(min = 2, message = ValidationMessages.INFO_TOO_SHORT)
    private String info;
    @NotNull(message = ValidationMessages.NULL_IMAGE)
    @Size(min = 5, message = ValidationMessages.IMAGE_TOO_SHORT)
    private String image;
}
