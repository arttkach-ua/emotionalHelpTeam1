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


//		if (!questionnaireRepository.existsByName("questionnaire 1")){
//			Questionnaire questionnaire = new Questionnaire();
//			questionnaire.setName("questionnaire 1");
//			questionnaire.setDescription("questionnaire description");
//
//			List<Question> questionList = new ArrayList<>();
//
//			for (int i = 1; i < 4; i++) {
//				Question question = new Question();
//				question.setName("question " + i);
//				question.setQuestionnaire(questionnaire);
//				List<Answer> answerList = new ArrayList<>();
//
//				for (int j = 1; j < 4; j++) {
//
//					Answer answer = new Answer();
//					answer.setName("answer " + j);
//					answer.setPoints(j*j);
//					answer.setQuestion(question);
//
//					answerList.add(answer);
//					System.out.println(answer);
//				}
//				question.setAnswersList(answerList);
//
//				questionList.add(question);
//			}
//
//			questionnaire.setQuestionList(questionList);
//
//			questionnaireRepository.save(questionnaire);
//
//
//		}


	}
}
