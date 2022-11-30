package com.epam.team1.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * This entity is used to store info about all possible quiz results
 * Scoring points starts from 0.
 * For example: Result 1 is 7 points. if user passed quiz for 6 this is result 1
 */
@Entity
@Table(name = "results")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Result extends BaseEntity {
    @ManyToOne()
    @JoinColumn(name = "questionaries_id")
    private Questionnaire questionnaire;
    @Column(name="points")
    private Integer points;
    @Column(name="short_description")
    private String shortDescription;
    @Column(name="full_description")
    private String fullDescription;
}
