package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "answer")
public class Answer extends BaseEntity {
    public Answer() {}

    @NotNull
    @Column(name = "answer", nullable = false, unique = true)
    private String answer;

    @NotNull
    @Column(name = "point", nullable = false, unique = false)
    private int point;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

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
