package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionDto;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionDtoMapper {
    @Autowired
    QuestionnaireService questionnaireService;

    public Question fromDto(QuestionDto dto){
        Question question = new Question();
        question.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        question.setName(dto.getName());
        return question;
    }
}
