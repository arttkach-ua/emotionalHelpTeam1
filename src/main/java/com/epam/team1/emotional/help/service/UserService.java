package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.UserAddDataRequestDto;
import com.epam.team1.emotional.help.dto.UserResponseDTO;
import com.epam.team1.emotional.help.exception.WrongUserIdException;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.security.UserDetailsImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public Boolean userIsAuthorized() {
        //TODO finish it
        return Boolean.TRUE;
    }

    public User getCurrentUser() {
        User currentUser;
        try {
            currentUser = ((UserDetailsImplementation) SecurityContextHolder.
                    getContext().
                    getAuthentication().
                    getPrincipal()).getUser();
        } catch (NullPointerException e) {
            return null;
        }
        return currentUser;
    }

    public UserResponseDTO getById(Long id) {
        User currentUser = getCurrentUser();
        if (!currentUser.getId().equals(id)){
            throw new WrongUserIdException("provided user id is not correct");
        }
        return userMapper.mapToResponseDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + id + " does not exists")));
    }

    public UserResponseDTO resetById(Long id, UserAddDataRequestDto userAddDataRequestDto) {
        User currentUser = getCurrentUser();
        if (!currentUser.getId().equals(id)){
            throw new WrongUserIdException("provided user id is not correct");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + id + " does not exists"));
        if (userAddDataRequestDto.getGender() != null) {
            user.setGender(userAddDataRequestDto.getGender());
        }
        if (userAddDataRequestDto.getCountry() != null) {
            user.setCountry(userAddDataRequestDto.getCountry());
        }
        if (userAddDataRequestDto.getBirthday() != null) {
            user.setBirthday(userAddDataRequestDto.getBirthday());
        }
        return userMapper.mapToResponseDto(userRepository.save(user));

    }

}
