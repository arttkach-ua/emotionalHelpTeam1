package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.quizHistory.QuizHistoryResponseDto;
import com.epam.team1.emotional.help.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class QuizHistoryMapper {
    public QuizHistoryResponseDto toQuizResponseDto(QuizHistory quizHistory){
        return QuizHistoryResponseDto.builder()
                .title(quizHistory.getQuestionnaire().getName())
                .createdDate(quizHistory.getCompleteDate())
                .description(quizHistory.getResult().getFullDescription())
                .build();
    }
    public List<QuizHistoryResponseDto> toQuizHistoryResponseDtoList(List<QuizHistory> quizHistories) {
        return quizHistories.stream()
                .map(this::toQuizResponseDto)
                .toList();
    }
    /**
     *
     * @param user - User optional
     * @param result - Result entity
     * @return Quiz history entity
     */
    public QuizHistory toQuizHistory(User user, Result result, Quiz quiz){
        return QuizHistory.builder()
                .user(user)
                .points(quiz.getTotalPoints())
                .result(result)
                .questionnaire(result.getQuestionnaire())
                .completeDate(LocalDateTime.now())
                .build();
    }
    public QuizHistory toQuizHistory(User user, Questionnaire questionnaire, Integer pointsScored, Result result){
        return QuizHistory.builder()
                .user(user)
                .questionnaire(questionnaire)
                .points(pointsScored)
                .result(result)
                .completeDate(LocalDateTime.now()).build();
    }
}
