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
@Table(name = "questionaries")
@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Questionnaire extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "questionnaire")
    private List<Question> questionList;
}