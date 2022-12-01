package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.QuestionResponseDto;
import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.dto.QuizDto;
import com.epam.team1.emotional.help.model.Questionnaire;
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
    public Questionnaire postQuiz(@RequestBody QuestionnaireDto dto){
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
    public QuizDto calculateQuiz(@RequestBody QuizDto dto){
        quizService.calculateQuiz(dto);

        QuizDto quizDto = new QuizDto();
        quizDto.setToken("1");
        quizDto.setQuestionnaireId(1L);
        QuizDto.CompleteAnswer answer = new QuizDto.CompleteAnswer();
        answer.setAnswerId(1L);
        answer.setQuestionId(1L);
        quizDto.setAnswers(List.of(answer));
        return quizDto;
    }
}
