package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Long> {
}
