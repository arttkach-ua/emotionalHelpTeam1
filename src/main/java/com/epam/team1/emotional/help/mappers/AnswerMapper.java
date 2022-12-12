package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.AnswerResponseDto;
import com.epam.team1.emotional.help.model.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class AnswerMapper {

  public AnswerResponseDto mapToResponseDto(Answer answer){
      log.info("Call of AnswerMapper.mapToResponseDto method. Params: answer , {}", answer);
      AnswerResponseDto answerResponseDTO = new AnswerResponseDto();
      answerResponseDTO.setId(answer.getId());
      answerResponseDTO.setName(answer.getName());

      return answerResponseDTO;
  }
    public List<AnswerResponseDto> toAnswerResponseDtoList(List<Answer> answers) {
        log.info("Call of AnswerMapper.toAnswerResponseDtoList method. Params: answers , {}", answers);
        return answers.stream()
                .map(this::mapToResponseDto)
                .toList();
    }
}
