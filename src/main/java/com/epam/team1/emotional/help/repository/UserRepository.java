package com.epam.team1.emotional.help.repository;


import com.epam.team1.emotional.help.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<User> findByAccessCodeId(Long id);

    User getByEmail(String username);
}
