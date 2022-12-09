package com.epam.team1.emotional.help.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_history")
@SuperBuilder
@RequiredArgsConstructor
@Getter
@Setter
public class QuizHistory extends BaseEntity{

    @Column(name = "points")
    private int points;
    @ManyToOne
    @JoinColumn(name = "questionnaires_id")
    private Questionnaire questionnaire;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @Column(name = "complete_date")
    LocalDateTime completeDate;
    @ManyToOne
    @JoinColumn(name = "results_id")
    Result result;

}
