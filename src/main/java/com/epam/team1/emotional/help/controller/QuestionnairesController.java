package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.*;
import com.epam.team1.emotional.help.service.QuestionService;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import com.epam.team1.emotional.help.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/questionnaires")
@CrossOrigin
public class QuestionnairesController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<QuestionnaireDto> getQuizzes(){
        return questionnaireService.findAllDto();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionnaireDto createQuiz(@Valid @RequestBody QuestionnaireDto dto){
        log.info("Call of /questionnaires endpoint.(Post method). dto is {}", dto);
        return questionnaireService.create(dto);
    }

    /**
     * Returns a list od questions for questionary
     * @param id
     * @return
     */
    @GetMapping("/{id}/questions")
    public List<QuestionResponseDto> getAllQuestionsByQuestionnaireId(@PathVariable("id") Long id){
        log.info("Call of /questionnaires/{id}/questions endpoint.(Post method). id is {}", id);
        return questionService.getAllDtoByQuestionnaireId(id);
    }

    /**
     * Method is used to calculate result of quiz
     * @param dto - json with answers
     * @return - dto with result
     */
    @PostMapping("/{id}/quiz")
    public QuizResponseDto calculateQuiz(@RequestBody QuizRequestDto dto){
        log.info("Call of /questionnaires/{id}/quiz endpoint.(Post method). dto is {}", dto);
        return quizService.processQuiz(dto);
    }
}
