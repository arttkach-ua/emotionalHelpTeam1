package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.mappers.ResultMapper;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.repository.ResultRepository;
import com.epam.team1.emotional.help.util.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultMapper resultMapper;
    private final ResultRepository resultRepository;
    private final QuestionnaireService questionnaireService;

    public ResultResponseDto create(ResultRequestDto dto){
        Result result = resultRepository.save(resultMapper.fromDto(dto));
        return resultMapper.toResultResponseDto(result);

    }

    private Result mapResultFromResultRequestDto(ResultRequestDto dto){
        Result result = resultMapper.fromDto(dto);
        result.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        return result;
    }

    public Result getResultByQuestionnaireAndPoints(Questionnaire questionnaire, Integer points){
        Optional<Result> result = resultRepository
                .findFirstByQuestionnaireAndPointsGreaterThanEqualOrderByPointsAsc(questionnaire, points);
        return result
                .orElseThrow(()->new EntityNotFoundException(ErrorMessages.RESULT_NOT_FOUND));
    }
}