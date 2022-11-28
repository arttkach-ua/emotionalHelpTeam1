package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{}
