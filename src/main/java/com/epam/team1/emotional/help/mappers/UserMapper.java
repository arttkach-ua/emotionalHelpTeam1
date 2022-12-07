package com.epam.team1.emotional.help.mappers;


import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.model.enums.Role;
import com.epam.team1.emotional.help.dto.SignupUserRequestDTO;
import com.epam.team1.emotional.help.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEntity(SignupUserRequestDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        return user;
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
