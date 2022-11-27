package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "answers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Answer extends BaseEntity {
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "quetisons_id")
    private Question question;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "points", nullable = false, unique = false)
    private int points;


}
