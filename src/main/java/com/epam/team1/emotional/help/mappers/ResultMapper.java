package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ResultMapper {

    public ResultRequestDto toDto(Result result){
        log.info("Call of ResultMapper.ResultRequestDto method. Params: result {}", result);
        return ResultRequestDto.builder()
                .points(result.getPoints())
                .questionnaireId(result.getQuestionnaire().getId())
                .fullDescription(result.getFullDescription())
                .shortDescription(result.getShortDescription())
                .build();
    }
    public Result fromDto(ResultRequestDto dto){
        log.info("Call of ResultMapper.fromDto method. Params: dto {}", dto);
        return Result.builder()
                .points(dto.getPoints())
                .shortDescription(dto.getShortDescription())
                .fullDescription(dto.getFullDescription())
                .build();
    }
    public ResultResponseDto toResultResponseDto(Result result){
        log.info("Call of ResultMapper.fromDto method. Params: result {}", result);
        return ResultResponseDto.builder()
                .id(result.getId())
                .questionnaireId(result.getQuestionnaire().getId())
                .shortDescription(result.getShortDescription())
                .fullDescription(result.getFullDescription())
                .points(result.getPoints())
                .build();
    }
}
