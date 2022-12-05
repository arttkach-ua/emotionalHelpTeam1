package com.epam.team1.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Question extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "questionnaires_id")
    private Questionnaire questionnaire;

    @NotNull
    //@Column(name = "name", nullable = false, unique = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answersList;
}
