package com.epam.team1.emotional.help.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Dto is used for passed quiz
 */
@Data
@NoArgsConstructor
public class QuizRequestDto {
    private String token;
    private Long questionnaireId;
    private List<CompleteAnswer> answers;

    @Data
    public static class CompleteAnswer{
        private Long questionId;
        private Long answerId;
    }
}