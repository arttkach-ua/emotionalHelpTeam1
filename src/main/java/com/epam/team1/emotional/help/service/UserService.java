package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.util.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import com.epam.team1.emotional.help.dto.UserAddDataRequestDto;
import com.epam.team1.emotional.help.dto.UserResponseDTO;
import com.epam.team1.emotional.help.exception.WrongUserIdException;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.security.UserDetailsImplementation;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    private final UserMapper userMapper;

    public User getUserById(Long id) {
        log.info("Call of UserService.getUserById({}) method.", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorMessages.USER_BY_ID_NOT_FOUND, id)));
    }

    public Optional<User> getCurrentUser() {
        log.info("Call of UserService.getCurrentUser({}) method.");
        return Optional.ofNullable(((UserDetailsImplementation) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal()).getUser());
      }

    public UserResponseDTO getById(Long id) {
        log.info("Call of UserService.getById({}) method.", id);
        User currentUser = getCurrentUser().orElseThrow(() -> new UsernameNotFoundException("user not found"));
        if (!currentUser.getId().equals(id)) {
            throw new WrongUserIdException("provided user id is not correct");
        }
        return userMapper.mapToResponseDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + id + " does not exists")));
    }

    public UserResponseDTO resetById(Long id, UserAddDataRequestDto userAddDataRequestDto) {
        log.info("Call of UserService.resetById method. Params: id {} userAddDataRequestDto {}", id, userAddDataRequestDto);
        User currentUser = getCurrentUser().orElseThrow(() -> new UsernameNotFoundException("user not found"));
        if (!currentUser.getId().equals(id)) {
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

    public Optional<User> findUserOptionalByEmail(String email){
        log.info("Call of UserService.findUserOptionalByEmail method. Params: email {}", email);
        return userRepository.findByEmail(email);
    }

    public User findUserByEmail(String email){
        log.info("Call of UserService.findUserByEmail method. Params: email {}", email);
        return findUserOptionalByEmail(email)
                .orElseThrow(()->new EntityNotFoundException(String.format(ErrorMessages.USER_BY_EMAIL_NOT_FOUND, email)));
    }

}
