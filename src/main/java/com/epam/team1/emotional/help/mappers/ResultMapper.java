package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.model.Result;
import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

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
                .shortDescription(dto.getShortDescription())
                .fullDescription(dto.getFullDescription())
                .build();
    }
    public ResultResponseDto toResultResponseDto(Result result){
        return ResultResponseDto.builder()
                .id(result.getId())
                .questionnaireId(result.getQuestionnaire().getId())
                .shortDescription(result.getShortDescription())
                .fullDescription(result.getFullDescription())
                .points(result.getPoints())
                .build();
    }
}
