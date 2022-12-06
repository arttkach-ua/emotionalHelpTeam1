package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionDto;
import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.mappers.QuestionDtoMapper;
import com.epam.team1.emotional.help.mappers.QuestionResponseMapper;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionDtoMapper questionDtoMapper;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionResponseMapper questionResponseMapper;

    public List<Question> getAllByQuestionnaireId(){
        //TODO: finish it
        return new ArrayList<>();
    }

    /**
     * Saves question entity to db
     * @param dto
     * @return saved entity
     */
    public Question create(QuestionDto dto){
        //TODO finish it
        Question question = mapQuestionFromQuestionDto(dto);
        return questionRepository.save(question);
    }

    public List<Question> getAllByQuestionnaireId(long id){
        Questionnaire questionnaire = questionnaireService.getById(id);
        return questionRepository.findByQuestionnaire(questionnaire);
    }

    /**
     * Gets all questions from db and convert it to QuestionResponseDto
     * @param id - id of questionnaire
     * @return list of questionResponse dto
     */
    public List<QuestionResponseDto> getAllDtoByQuestionnaireId(long id){
        return getAllByQuestionnaireId(id).stream()
                .map(questionResponseMapper::toQuestionResponseDto)
                .toList();
    }
    public Question mapQuestionFromQuestionDto(QuestionDto dto){
        Question question = questionDtoMapper.toQuestion(dto);
        question.setQuestionnaire(questionnaireService.getById(dto.getQuestionnaireId()));
        return question;
    }
}
