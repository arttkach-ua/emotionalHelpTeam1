package com.epam.team1.emotional.help.dto.request;


import com.epam.team1.emotional.help.security.validation.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class SignupUserRequestDTO {

    @Size(min = 2, max = 50)
    @NotEmpty(message = "*Please provide your first name")
    private String name;

    @Email
    private String email;

    @ValidPassword
    private String password;

}
