package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.dto.UserAdditionalDataRequestDto;
import com.epam.team1.emotional.help.dto.UserResponseDTO;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public Boolean userIsAuthorized(){
        //TODO finish it
        return Boolean.TRUE;
    }

}
