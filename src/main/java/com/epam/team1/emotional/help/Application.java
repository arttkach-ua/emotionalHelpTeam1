package com.epam.team1.emotional.help;

import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.model.Question;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.model.enums.Gender;
import com.epam.team1.emotional.help.model.enums.Role;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import com.epam.team1.emotional.help.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {


    private final QuestionnaireRepository questionnaireRepository;
    private final UserRepository userRepository;

   private final PasswordEncoder passwordEncoder;


    public Application(QuestionnaireRepository questionnaireRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.questionnaireRepository = questionnaireRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        if (!userRepository.existsByEmail("heghine@gmail.com")) {
            User user1 = new User();
            user1.setCountry("Armenia");
            user1.setName("Heghine");
            user1.setEmail("heghine@gmail.com");
            user1.setRole(Role.USER);
            user1.setEnabled(true);
            user1.setPassword(passwordEncoder.encode("Aaaaaaaa@2"));
            user1.setGender(Gender.Female);
            userRepository.save(user1);
        }

        if (!userRepository.existsByEmail("user2@gmail.com")) {
            User user2 = new User();
            user2.setCountry("Armenia");
            user2.setName("user2");
            user2.setEmail("user2@gmail.com");
            user2.setRole(Role.USER);
            user2.setEnabled(true);
            user2.setPassword(passwordEncoder.encode("Assssssss#@"));
            user2.setGender(Gender.Male);
            userRepository.save(user2);
        }

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

