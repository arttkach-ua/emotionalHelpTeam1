package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuizDto;
import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private AnswersService answersService;

    public void calculateQuiz(QuizDto dto){
        Quiz quiz = mapTestDtoToTest(dto);
        calculateTotalPoints(quiz);
        quiz.setTotalPoints(calculateTotalPoints(quiz));
        Result result = resultService.getResult(quiz.getQuestionnaire(),quiz.getTotalPoints());
        //Todo finish it
    }

    public Quiz mapTestDtoToTest(QuizDto dto){
        Quiz quiz = new Quiz();
        quiz.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        quiz.setAnswers(dto.getAnswers().stream()
                .map(a->answersService.getById(a.getAnswerId()))
                .toList());
        return quiz;
    }

    public Integer calculateTotalPoints(Quiz quiz){
        return quiz.getAnswers().stream()
                .mapToInt(Answer::getPoints)
                .sum();
    }
}
