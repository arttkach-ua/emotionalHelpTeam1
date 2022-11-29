package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionDto;
import com.epam.team1.emotional.help.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionDtoMapper {
    public Question toQuestion(QuestionDto dto){
        Question question = new Question();
        question.setName(dto.getName());
        return question;
    }
}
