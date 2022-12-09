package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.quizHistory.QuizHistoryResponseDto;
import com.epam.team1.emotional.help.model.QuizHistory;
import org.springframework.stereotype.Component;

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
}
