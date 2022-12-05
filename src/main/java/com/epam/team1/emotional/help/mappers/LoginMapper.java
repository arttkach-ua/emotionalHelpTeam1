package com.epam.team1.emotional.help.mappers;


import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.dto.request.LoginRequestDTO;
import com.epam.team1.emotional.help.dto.response.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public User mapToEntity(LoginRequestDTO loginRequestDTO) {
        return null;
    }

    public UserResponseDTO mapToResponseDto(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setImage(user.getImage());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setBirthday(user.getBirthday());
        response.setGender(user.getGender());
        response.setCountry(user.getCountry());
        response.setRole(user.getRole());
        return response;
    }
}
