package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "questionnaire")
/*
The data annotation includes the following
 @ToString,
 @EqualsAndHashCode,
 @Getter on all fields,
 @Setter on all non-final fields,
 @RequiredArgsConstructor
 */
@Data
@NoArgsConstructor
public class Questionnaire extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    private List<Question> questionList;
}
