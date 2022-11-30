package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query(value = "select r from Result r where r.questionnaire = :questionnaire and r.points>= :points ORDER BY r.points ASC")
    List<Result> getByPoints(@Param("questionnaire")Questionnaire questionnaire,
                             @Param("points")Integer points);
}
