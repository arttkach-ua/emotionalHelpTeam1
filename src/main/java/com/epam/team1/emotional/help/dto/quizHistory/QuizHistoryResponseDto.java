package com.epam.team1.emotional.help.dto.quizHistory;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class QuizHistoryResponseDto {
    String title;
    String description;
    LocalDateTime createdDate;
}
