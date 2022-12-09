package com.epam.team1.emotional.help;

import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private final QuestionnaireRepository questionnaireRepository;

    public Application(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

