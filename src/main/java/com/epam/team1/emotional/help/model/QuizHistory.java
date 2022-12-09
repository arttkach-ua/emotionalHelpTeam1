package com.epam.team1.emotional.help.model;

import javax.persistence.*;

@Entity
@Table(name = "quiz_history")
public class QuizHistory extends BaseEntity{

    @Column(name = "points")
    private int points;

    @ManyToOne
    @JoinColumn(name = "questionnaires_id")
    private Questionnaire questionnaire;


    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
