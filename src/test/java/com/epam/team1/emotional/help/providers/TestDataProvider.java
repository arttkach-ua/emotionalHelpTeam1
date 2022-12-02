package com.epam.team1.emotional.help.providers;

import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    /**
     * Method is used to generate questionnaire entity which will be used in tests
     * @return List<Questionnaire> - List with entity cases
     */
    public static Questionnaire getSingleQuestionnaireForTests(){
        Questionnaire questionnaire = Questionnaire.builder()
                .id(1L)
                .name("test1")
                .description("desk1")
                .build();
        return questionnaire;
    }

    public static List<Questionnaire> getQuestionnairesForTests(){
        List<Questionnaire> questionnaires = new ArrayList<>();
        questionnaires.add(Questionnaire.builder().id(1L).name("test1").description("desk1").build());
        questionnaires.add(Questionnaire.builder().id(2L).name("test2").description("desk2").build());
        return questionnaires;
    }

    public static List<Question> getSingleQuestionForTests(){
        Question question = Question.builder()
                .id(1L)
                .name("test question")
                .questionnaire(getSingleQuestionnaireForTests())
                .answersList(new ArrayList<>())
                .build();
        return List.of(question);
    }

}
