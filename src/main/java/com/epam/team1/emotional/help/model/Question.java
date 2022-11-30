package com.epam.team1.emotional.help.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
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
    @JsonIgnore//TODO удалить эту аннотацию. Для этого не возвращать ентити
    @ManyToOne()
    @JoinColumn(name = "questionaries_id")
    private Questionnaire questionnaire;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answersList;
}
