package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.mappers.ResultMapper;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private QuestionnaireService questionnaireService;

    public Result create(ResultRequestDto dto){
        Result result = resultMapper.fromDto(dto);
        return resultRepository.save(result);
    }

    private Result mapResultFromResultRequestDto(ResultRequestDto dto){
        Result result = resultMapper.fromDto(dto);
        result.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        return result;
    }

    public Result getResult(Questionnaire questionnaire, Integer points){
        List<Result> results = resultRepository.getByPoints(questionnaire, points);
        if (results.size()!=0){
            return results.get(0);
        }else{
            //TODO:add message here
            throw new EntityNotFoundException("result not found");
        }
    }
}
