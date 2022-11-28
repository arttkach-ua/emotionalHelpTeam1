//package com.epam.team1.emotional.help.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.Objects;
//
//@Entity(name = "questionnaire")
//@Setter
//@Getter
//@NoArgsConstructor
//public class Questionnaire extends BaseEntity {
//
//
//
//    @NotNull
//    @Column(name = "name", nullable = false, unique = true)
//    private String name;
//
//    @NotNull
//    @Column(name = "description")
//    private String description;
//
//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "questionnaire_id")
//    private List<Question> questionList;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Questionnaire that = (Questionnaire) o;
//        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(questionList, that.questionList);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, description, questionList);
//    }
//
//    @Override
//    public String toString() {
//        return "Questionnaire{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", questionList=" + questionList +
//                '}';
//    }
//}
