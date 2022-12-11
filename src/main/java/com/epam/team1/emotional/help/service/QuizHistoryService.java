package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.SendQuizResultToEmailDto;
import com.epam.team1.emotional.help.dto.quizHistory.QuizHistoryResponseDto;
import com.epam.team1.emotional.help.mappers.QuizHistoryMapper;
import com.epam.team1.emotional.help.model.*;
import com.epam.team1.emotional.help.repository.QuizHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizHistoryService {
    private final QuizHistoryRepository quizHistoryRepository;
    private final UserService userService;
    private final QuizHistoryMapper quizHistoryMapper;
    private final QuestionnaireService questionnaireService;
    private final ResultService resultService;

    public boolean saveToQuizHistory(Result result, Quiz quiz) {
        Optional<User> userOptional = userService.getCurrentUser();
        if (userOptional.isEmpty()){
            return false;
        }
        QuizHistory quizHistory = quizHistoryMapper.toQuizHistory(userOptional.get(), result, quiz);
        quizHistoryRepository.save(quizHistory);
        return true;
    }
    public List<QuizHistoryResponseDto> getQuizHistoryByUser(Long userId) {
        User user = userService.getUserById(userId);
        List<QuizHistory> quizHistories = quizHistoryRepository.findByUser(user);
        return quizHistoryMapper.toQuizHistoryResponseDtoList(quizHistories);
    }
    public void saveQuizForUnauthenticatedUser(SendQuizResultToEmailDto dto){
        User user = userService.findUserByEmail(dto.getEmail());
        Questionnaire questionnaire = questionnaireService.getById(dto.getQuestionnaireId());
        Result result = resultService.getResultByQuestionnaireAndPoints(questionnaire,dto.getPoints());

        QuizHistory quizHistory = quizHistoryMapper.toQuizHistory(user,questionnaire,dto.getPoints(),result);

        quizHistoryRepository.save(quizHistory);
        log.trace(String.format("Quiz history for email %s saved successfully",dto.getEmail()));
    }
}
