package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.dto.TestDto;
import lombok.Data;

import java.util.List;

@Data
public class Test {
    //private String token;
    private Questionnaire questionnaire;
    private List<Answer> answers;
    private Integer totalPoints;
}
