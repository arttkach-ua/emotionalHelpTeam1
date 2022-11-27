package com.epam.team1.emotional.help.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "answer")
@Setter
@Getter
@NoArgsConstructor
public class Answer extends BaseEntity {

    @NotNull
    @Column(name = "answer", nullable = false, unique = true)
    private String answer;

    @NotNull
    @Column(name = "point", nullable = false, unique = false)
    private int point;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return point == answer1.point && Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, point);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", point=" + point +
                '}';
    }
}
