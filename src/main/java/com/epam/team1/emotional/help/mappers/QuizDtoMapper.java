package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuizDto;
import com.epam.team1.emotional.help.model.Quiz;
import org.springframework.stereotype.Component;

@Component
public class QuizDtoMapper {

    public QuizDto toDTO(Quiz quiz){
        return QuizDto.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .description(quiz.getDescription())
                .build();
    }

    public Quiz fromDto(QuizDto dto){
        return Quiz.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

    }
}
