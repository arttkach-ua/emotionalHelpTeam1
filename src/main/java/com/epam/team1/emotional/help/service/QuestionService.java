package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionRequestDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.mappers.QuestionMapper;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final QuestionnaireService questionnaireService;

    public List<Question> getAllByQuestionnaireId(){
        //TODO: finish it
        return new ArrayList<>();
    }

    /**
     * Saves question entity to db
     * @param dto
     * @return QuestionResponseDto with saved entity
     */
    public QuestionResponseDto create(QuestionRequestDto dto){
        log.info("Call of QuestionService.create method. dto is {}", dto);
        Question question = mapQuestionFromQuestionDto(dto);
        return questionMapper.toQuestionResponseDto(questionRepository.save(question));
    }

    public List<Question> getAllByQuestionnaireId(long id){
        log.info("Call of QuestionService.getAllByQuestionnaireId({}) method.", id);
        Questionnaire questionnaire = questionnaireService.getById(id);
        return questionRepository.findByQuestionnaire(questionnaire);
    }

    /**
     * Gets all questions from db and convert it to QuestionResponseDto
     * @param id - id of questionnaire
     * @return list of questionResponse dto
     */
    public List<QuestionResponseDto> getAllDtoByQuestionnaireId(long id){
        log.info("Call of QuestionService.getAllDtoByQuestionnaireId({}) method.", id);
        return getAllByQuestionnaireId(id).stream()
                .map(questionMapper::toQuestionResponseDto)
                .toList();
    }
    public Question mapQuestionFromQuestionDto(QuestionRequestDto dto){
        log.info("Call of QuestionService.mapQuestionFromQuestionDto method. dto is {}", dto);
        Question question = questionMapper.toQuestion(dto);
        question.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        return question;
    }
}