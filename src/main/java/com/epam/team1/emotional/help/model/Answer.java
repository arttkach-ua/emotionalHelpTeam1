package com.epam.team1.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "answers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Answer extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "questions_id")
    private Question question;

    @NotNull
    //@Column(name = "name", nullable = false, unique = false)
    private String name;

    @NotNull
    // @Column(name = "points", nullable = false, unique = false)
    private int points;


}
