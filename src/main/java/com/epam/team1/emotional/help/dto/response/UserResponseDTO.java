package com.epam.team1.emotional.help.dto.response;

import com.epam.team1.emotional.help.model.enums.Gender;
import com.epam.team1.emotional.help.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String image;
    private String name;
    private String email;
    private LocalDateTime birthday;
    private Gender gender;
    private String country;
    private Role role;


}