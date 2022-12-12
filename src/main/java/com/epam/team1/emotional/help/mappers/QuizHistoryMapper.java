package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.quizHistory.QuizHistoryResponseDto;
import com.epam.team1.emotional.help.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Component
public class QuizHistoryMapper {

    public QuizHistoryResponseDto toQuizResponseDto(QuizHistory quizHistory){
        log.info("Call of QuizHistoryMapper.toQuizResponseDto method. Params: quizHistory {}", quizHistory);
        return QuizHistoryResponseDto.builder()
                .title(quizHistory.getQuestionnaire().getName())
                .createdDate(quizHistory.getCompleteDate())
                .description(quizHistory.getResult().getFullDescription())
                .build();
    }
    public List<QuizHistoryResponseDto> toQuizHistoryResponseDtoList(List<QuizHistory> quizHistories) {
        log.info("Call of QuizHistoryMapper.toQuizHistoryResponseDtoList method. Params: quizHistories {}", quizHistories);
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
        log.info("Call of QuizHistoryMapper.toQuizHistory method. Params: user {}, result {}, quiz {}", user, result, quiz);
        return QuizHistory.builder()
                .user(user)
                .points(quiz.getTotalPoints())
                .result(result)
                .questionnaire(result.getQuestionnaire())
                .completeDate(LocalDateTime.now())
                .build();
    }
    public QuizHistory toQuizHistory(User user, Questionnaire questionnaire, Integer pointsScored, Result result){
        log.info("Call of QuizHistoryMapper.toQuizHistory method. Params: user {}, questionnaire {}, quiz {}, result {}", user, questionnaire, pointsScored, result);
        return QuizHistory.builder()
                .user(user)
                .questionnaire(questionnaire)
                .points(pointsScored)
                .result(result)
                .completeDate(LocalDateTime.now()).build();
    }
}
