package com.epam.team1.emotional.help.model;

import lombok.Data;

import java.util.List;

@Data
public class Quiz {
    //private String token;
    private Questionnaire questionnaire;
    private List<Answer> answers;
    private Integer totalPoints;
}
