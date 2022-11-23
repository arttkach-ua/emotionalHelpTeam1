package com.epam.team1.emotional.help.service.Impl;

import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Override
    public List<Quiz> findAll() {
        //ToDO: remake to repo
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(Quiz.builder()
                .id(1)
                .name("quiz 1")
                .description("test description 1")
                .build());
        quizzes.add(Quiz.builder()
                .id(2)
                .name("quiz 2")
                .description("test description 2")
                .build());
        return quizzes;
    }
}
