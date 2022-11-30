package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.TestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @PostMapping
    TestDto calculateResult(@RequestBody TestDto dto){
        TestDto testDto = new TestDto();
        testDto.setToken("1");
        testDto.setQuestionnaireId(1L);
        TestDto.CompleteAnswer answer = new TestDto.CompleteAnswer();
        answer.setAnswerId(1L);
        answer.setQuestionId(1L);
        testDto.setAnswers(List.of(answer));
        return testDto;
    }
}
