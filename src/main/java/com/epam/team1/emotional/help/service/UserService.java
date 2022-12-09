package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.security.UserDetailsImplementation;
import com.epam.team1.emotional.help.util.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format(ErrorMessages.USER_NOT_FOUND,id)));
    }

    public Optional<User> getCurrentUser() {
        try {
            return  Optional.of(((UserDetailsImplementation) SecurityContextHolder.
                    getContext().
                    getAuthentication().
                    getPrincipal()).getUser());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
