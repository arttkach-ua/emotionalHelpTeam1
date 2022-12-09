package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.security.UserDetailsImplementation;
import com.epam.team1.emotional.help.util.ErrorMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorMessages.USER_NOT_FOUND, id)));
    }

    public Optional<User> getCurrentUser() {
        return Optional.ofNullable(((UserDetailsImplementation) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal()).getUser());
    }
}
