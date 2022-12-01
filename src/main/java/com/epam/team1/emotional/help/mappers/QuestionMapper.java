package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.AnswerResponseDto;
import com.epam.team1.emotional.help.dto.QuestionRequestDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public Question toQuestion(QuestionRequestDto dto){
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
        return QuestionResponseDto.builder()
                .id(question.getId())
                .name(question.getName())
                .answers(answerMapper.toAnswerResponseDtoList(question.getAnswersList()))
                .build();
    }



    public List<QuestionResponseDto> toQuestionResponseDtoList(List<Question> questions){
        return questions.stream()
                .map(this::toQuestionResponseDto)
                .toList();
    }
}