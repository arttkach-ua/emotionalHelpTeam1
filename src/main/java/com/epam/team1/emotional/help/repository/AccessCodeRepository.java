package com.epam.team1.emotional.help.repository;


import com.epam.team1.emotional.help.model.AccessCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessCodeRepository extends JpaRepository<AccessCode,Long> {
    Optional<AccessCode> findByCode(String code);
}