package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuizRequestDto;
import com.epam.team1.emotional.help.dto.QuizResponseDto;
import com.epam.team1.emotional.help.mappers.ResultMapper;
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
    @Autowired
    private ResultMapper resultMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private QuizHistoryService quizHistoryService;

    public QuizResponseDto calculateQuiz(QuizRequestDto dto){
        Quiz quiz = mapTestDtoToTest(dto);
        calculateTotalPoints(quiz);
        quiz.setTotalPoints(calculateTotalPoints(quiz));
        Result result = resultService.getResultByQuestionnaireAndPoints(quiz.getQuestionnaire(),quiz.getTotalPoints());
        quizHistoryService.saveToQuizHistory(result, quiz);
        return prepareQuizResponseDto(result, quiz);
    }

    public Quiz mapTestDtoToTest(QuizRequestDto dto){
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
    public QuizResponseDto prepareQuizResponseDto(Result result, Quiz quiz){
        QuizResponseDto dto = new QuizResponseDto();
        dto.setDescription(result.getFullDescription());
        dto.setTotalPoints(quiz.getTotalPoints());
        return dto;
    };
}
