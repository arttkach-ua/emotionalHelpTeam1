package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.request.ResultRequestDto;
import com.epam.team1.emotional.help.mappers.ResultMapper;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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
        Optional<Result> result = resultRepository
                .findFirstByQuestionnaireAndPointsGreaterThanEqualOrderByPointsAsc(questionnaire, points);
        //TODO:add message here
        return result
                .orElseThrow(()->new EntityNotFoundException("result not found"));
    }
}
