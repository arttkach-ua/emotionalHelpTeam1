package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questionnaires")
@CrossOrigin
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;


}
