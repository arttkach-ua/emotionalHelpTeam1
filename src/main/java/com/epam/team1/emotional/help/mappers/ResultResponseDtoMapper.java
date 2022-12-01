package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.model.Result;

public class ResultResponseDtoMapper {
    public ResultResponseDto toDto(Result result){
        return ResultResponseDto.builder()
                .id(result.getId())
                .points(result.getPoints())
                .questionnaireId(result.getQuestionnaire().getId())
                .fullDescription(result.getFullDescription())
                .shortDescription(result.getShortDescription())
                .build();
    }
    public Result fromDto(ResultResponseDto dto){
        return Result.builder()
                .points(dto.getPoints())
                .shortDescription(dto.getShortDescription())
                .fullDescription(dto.getFullDescription())
                .build();
    }
}
