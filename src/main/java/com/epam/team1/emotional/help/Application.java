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


        if (!questionnaireRepository.existsByName("questionnaire 1")) {


            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setName("questionnaire 1");
            questionnaire.setDescription("questionnaire description");

            List<Question> questionList = new ArrayList<>();



//            Question question1 = new Question();
//            question1.setName("question 1");
//            question1.setQuestionnaire(questionnaire);
//
//            Answer answer1q1 = new Answer();
//            answer1q1.setQuestion(question1);
//            answer1q1.setName("Answer 1q1");
//            answer1q1.setPoints(2);
//
//            Answer answer2q1 = new Answer();
//            answer2q1.setQuestion(question1);
//            answer2q1.setName("Answer 2q1");
//            answer2q1.setPoints(2);
//
//            Answer answer3q1 = new Answer();
//            answer3q1.setQuestion(question1);
//            answer3q1.setName("Answer 3q1");
//            answer3q1.setPoints(2);
//
//            Answer answer4q1 = new Answer();
//            answer1q1.setQuestion(question1);
//            answer1q1.setName("Answer 4q1");
//            answer1q1.setPoints(2);
//
//            ArrayList<Answer> answerListq1 = new ArrayList<>();
//            answerListq1.add(answer1q1);
//            answerListq1.add(answer2q1);
//            answerListq1.add(answer3q1);
//            answerListq1.add(answer4q1);
//
//            question1.setAnswersList(answerListq1);

            Question question2 = new Question();
            question2.setName("question 2");
            question2.setQuestionnaire(questionnaire);

            Answer answer1q2 = new Answer();
            answer1q2.setQuestion(question2);
            answer1q2.setName("Answer 1q2");
            answer1q2.setPoints(2);

            Answer answer2q2 = new Answer();
            answer2q2.setQuestion(question2);
            answer2q2.setName("Answer 2q2");
            answer2q2.setPoints(2);

            Answer answer3q2 = new Answer();
            answer3q2.setQuestion(question2);
            answer3q2.setName("Answer 3q2");
            answer3q2.setPoints(2);

            Answer answer4q2 = new Answer();
            answer4q2.setQuestion(question2);
            answer4q2.setName("Answer 4q2");
            answer4q2.setPoints(2);


            ArrayList<Answer> answerListq2 = new ArrayList<>();
            answerListq2.add(answer1q2);
            answerListq2.add(answer2q2);
            answerListq2.add(answer3q2);
            answerListq2.add(answer4q2);

            question2.setAnswersList(answerListq2);

        //    questionList.add(question1);
            questionList.add(question2);


        questionnaire.setQuestionList(questionList);

        questionnaireRepository.save(questionnaire);


    }


}
}
