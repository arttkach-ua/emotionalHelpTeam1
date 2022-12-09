package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.quizHistory.QuizHistoryResponseDto;
import com.epam.team1.emotional.help.mappers.QuizHistoryMapper;
import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.model.QuizHistory;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.QuizHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizHistoryService {
    @Autowired
    private QuizHistoryRepository quizHistoryRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private QuizHistoryMapper quizHistoryMapper;


    public boolean saveToQuizHistory(Result result, Quiz quiz) {
        Optional<User> userOptional = userService.getCurrentUser();
        if (userOptional.isEmpty()){
            return false;
        }
        QuizHistory quizHistory = createQuizHistory(userOptional.get(), result, quiz);
        quizHistoryRepository.save(quizHistory);
        return true;
    }

    /**
     *
     * @param user - User optional
     * @param result - Result entity
     * @return true record created, false if not
     */
    public QuizHistory createQuizHistory(User user, Result result, Quiz quiz){
        return QuizHistory.builder()
                .user(user)
                .points(quiz.getTotalPoints())
                .result(result)
                .questionnaire(result.getQuestionnaire())
                .completeDate(LocalDateTime.now())
                .build();
    }

    public List<QuizHistoryResponseDto> getQuizHistoryByUser(Long userId) {
        User user = userService.getUserById(userId);
        List<QuizHistory> quizHistories = quizHistoryRepository.findByUser(user);
        return quizHistoryMapper.toQuizHistoryResponseDtoList(quizHistories);
    }
}
