package com.epam.team1.emotional.help;

import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {


    private final QuestionnaireRepository questionnaireRepository;

    public Application(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        if (!questionnaireRepository.existsByName("questionnaire 1")){

            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setName("questionnaire 1 " + UUID.randomUUID().toString());
            questionnaire.setDescription("questionnaire description");

            List<Question> questionList = new ArrayList<>();

            for (int i = 1; i < 5; i++) {
                Question question = new Question();
                question.setName("question " + i + "  " + UUID.randomUUID().toString() );
                question.setQuestionnaire(questionnaire);
                List<Answer> answerList = new ArrayList<>();

                for (int j = 1; j < 5; j++) {

                    Answer answer = new Answer();
                    answer.setName("answer " + j + "  " +  UUID.randomUUID().toString());
                    answer.setPoints(j*j);
                    answer.setQuestion(question);

                    answerList.add(answer);
                    System.out.println(answer);
                }
                question.setAnswersList(answerList);

                questionList.add(question);
            }

            questionnaire.setQuestionList(questionList);

            questionnaireRepository.save(questionnaire);


        }

    }


}

