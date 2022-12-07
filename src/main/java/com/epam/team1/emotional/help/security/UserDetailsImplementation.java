package com.epam.team1.emotional.help.security;


import com.epam.team1.emotional.help.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class UserDetailsImplementation extends org.springframework.security.core.userdetails.User {

    private User user;

    public UserDetailsImplementation(User user) {

        super(user.getEmail(), user.getPassword(), user.isEnabled(),
                true,
                true,
                !user.isBlocked(),
                AuthorityUtils.createAuthorityList("ROLE_" + user.getRole().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}