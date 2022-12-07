package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.SignupUserRequestDTO;
import com.epam.team1.emotional.help.dto.SignupResponseDTO;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.model.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class SignupMapper {

    public User mapToEntity(SignupUserRequestDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        return user;
    }


    public SignupResponseDTO mapToResponseDto(User user) {
        SignupResponseDTO response = new SignupResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }

}
