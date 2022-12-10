package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuizRequestDto;
import com.epam.team1.emotional.help.dto.QuizResponseDto;
import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.model.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuestionnaireService questionnaireService;
    private final ResultService resultService;
    private final AnswersService answersService;
    private final QuizHistoryService quizHistoryService;

    public QuizResponseDto processQuiz(QuizRequestDto dto){
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
    }
}
