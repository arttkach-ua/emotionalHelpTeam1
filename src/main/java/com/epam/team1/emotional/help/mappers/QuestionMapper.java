package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.QuestionRequestDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public Question toQuestion(QuestionRequestDto dto){
        log.info("Call of QuestionMapper.toQuestion method. Params: dto , {}", dto);
        Question question = new Question();
        question.setName(dto.getName());
        return question;
    }

    /**
     * Maps Question entity to QuestionResponseDto
     * @param question
     * @return QuestionResponseDto
     */
    public QuestionResponseDto toQuestionResponseDto(Question question){
        log.info("Call of QuestionMapper.toQuestionResponseDto method. Params: question , {}", question);
        return QuestionResponseDto.builder()
                .id(question.getId())
                .name(question.getName())
                .answers(answerMapper.toAnswerResponseDtoList(question.getAnswersList()))
                .build();
    }

    public List<QuestionResponseDto> toQuestionResponseDtoList(List<Question> questions){
        log.info("Call of QuestionMapper.toQuestionResponseDtoList method. Params: questions , {}", questions);
        return questions.stream()
                .map(this::toQuestionResponseDto)
                .toList();
    }
}