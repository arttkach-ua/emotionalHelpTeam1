package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
