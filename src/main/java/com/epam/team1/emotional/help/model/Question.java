package com.epam.team1.emotional.help.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity(name = "question")
@Setter
@Getter
@NoArgsConstructor
public class Question extends BaseEntity {

    @NotNull
    @Column(name = "question", nullable = false, unique = true)
    private String question;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answer> answersList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answersList, question1.answersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answersList);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answersList=" + answersList +
                '}';
    }
}
