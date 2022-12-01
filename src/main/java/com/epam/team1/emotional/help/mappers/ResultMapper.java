package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.model.Result;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

    public ResultRequestDto toResultRequestDto(Result result){
        return ResultRequestDto.builder()
                .points(result.getPoints())
                .questionnaireId(result.getQuestionnaire().getId())
                .fullDescription(result.getFullDescription())
                .shortDescription(result.getShortDescription())
                .build();
    }
    public ResultResponseDto toResultResponseDto(Result result){
        return ResultResponseDto.builder()
                .id(result.getId())
                .points(result.getPoints())
                .questionnaireId(result.getQuestionnaire().getId())
                .fullDescription(result.getFullDescription())
                .shortDescription(result.getShortDescription())
                .build();
    }

    public Result toResult(ResultRequestDto dto){
        return Result.builder()
                .points(dto.getPoints())
                .shortDescription(dto.getShortDescription())
                .fullDescription(dto.getFullDescription())
                .build();
    }

}
