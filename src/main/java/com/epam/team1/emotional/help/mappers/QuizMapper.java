package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuizResponseDto;
import com.epam.team1.emotional.help.model.Quiz;
import com.epam.team1.emotional.help.model.Result;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {
    public QuizResponseDto toQuizResponseDto(Boolean userIsAuthorized, Result result, Quiz quiz){
        QuizResponseDto dto = new QuizResponseDto();
        dto.setDescription(userIsAuthorized==Boolean.TRUE?result.getFullDescription() : result.getShortDescription());
        dto.setTotalPoints(quiz.getTotalPoints());
        return dto;
    };
}
