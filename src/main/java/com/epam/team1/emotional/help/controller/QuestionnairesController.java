package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.dto.QuizRequestDto;
import com.epam.team1.emotional.help.service.QuestionService;
import com.epam.team1.emotional.help.service.QuestionnaireService;
import com.epam.team1.emotional.help.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaires")
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
    public QuestionnaireDto createQuiz(@RequestBody QuestionnaireDto dto){
        return questionnaireService.create(dto);
    }

    /**
     * Returns a list od questions for questionary
     * @param id
     * @return
     */
    @GetMapping("/{id}/questions")
    public List<QuestionResponseDto> getAllQuestionsByQuestionnaireId(@PathVariable("id") long id){
        return questionService.getAllDtoByQuestionnaireId(id);
    }

    /**
     * Method is used to calculate result of quiz
     * @param dto - json with answers
     * @return - dto with result
     */
    @PostMapping("/{id}/quiz")
    public QuizRequestDto calculateQuiz(@RequestBody QuizRequestDto dto){
        quizService.calculateQuiz(dto);
        //Todo::: delete it after finishing quiz service
        QuizRequestDto quizRequestDto = new QuizRequestDto();
        quizRequestDto.setToken("1");
        quizRequestDto.setQuestionnaireId(1L);
        QuizRequestDto.CompleteAnswer answer = new QuizRequestDto.CompleteAnswer();
        answer.setAnswerId(1L);
        answer.setQuestionId(1L);
        quizRequestDto.setAnswers(List.of(answer));
        return quizRequestDto;
    }
}
