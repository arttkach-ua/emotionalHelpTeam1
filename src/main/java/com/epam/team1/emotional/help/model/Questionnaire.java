package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity(name = "questionnaire")
public class Questionnaire extends BaseEntity {

    public Questionnaire() {
    }

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    private List<Question> questionList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire that = (Questionnaire) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(questionList, that.questionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, questionList);
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
