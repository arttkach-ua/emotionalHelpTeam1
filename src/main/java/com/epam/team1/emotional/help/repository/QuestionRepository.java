package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByQuestionnaire(Questionnaire questionnaire);
}
