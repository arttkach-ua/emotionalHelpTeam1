package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {
    @Autowired
    QuestionnaireService questionnaireService;

    public ResultRequestDto toDto(Result result){
        return ResultRequestDto.builder()
                .points(result.getPoints())
                .questionnaireId(result.getQuestionnaire().getId())
                .fullDescription(result.getFullDescription())
                .shortDescription(result.getShortDescription())
                .build();
    }
    public Result fromDto(ResultRequestDto dto){
        return Result.builder()
                .points(dto.getPoints())
                .questionnaire(questionnaireService.getById(dto.getQuestionnaireId()))
                .shortDescription(dto.getShortDescription())
                .fullDescription(dto.getFullDescription())
                .build();
    }

}
