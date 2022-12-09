package com.epam.team1.emotional.help.repository;

import com.epam.team1.emotional.help.model.QuizHistory;
import com.epam.team1.emotional.help.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Long> {
    List<QuizHistory> findByUser(User user);
}
