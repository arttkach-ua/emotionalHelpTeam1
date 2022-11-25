package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "question")
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
public class Question extends BaseEntity {
    @NotNull
    @Column(name = "question", nullable = false, unique = true)
    private String question;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answer> answersList;


}
