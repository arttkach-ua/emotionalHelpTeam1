package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    @Repository
    interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {
    }
}
