package com.epam.team1.emotional.help.dto;


import com.epam.team1.emotional.help.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAdditionalDataRequestDto {

    private LocalDateTime birthday;
    private String country;
    private Gender gender;

}
