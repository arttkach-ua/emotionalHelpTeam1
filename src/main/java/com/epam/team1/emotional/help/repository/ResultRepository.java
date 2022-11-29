package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    Optional<Result> findFirstByQuestionnaireAndPointsGreaterThanEqualOrderByPointsAsc(
            @Param("questionnaire")Questionnaire questionnaire,
            @Param("points")Integer points);
}
