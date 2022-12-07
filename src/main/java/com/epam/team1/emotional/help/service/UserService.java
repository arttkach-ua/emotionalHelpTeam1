package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.security.UserDetailsImplementation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Boolean userIsAuthorized() {
        //TODO finish it
        return Boolean.TRUE;
    }



    private User getCurrentUser() {
        return ((UserDetailsImplementation) SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal()).getUser();
    }
}
