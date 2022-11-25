package com.epam.team1.emotional.help.service.Impl;

import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public Questionnaire getById(Long questionnaire_id) {

        return questionnaireRepository
                .findById(questionnaire_id)
                .orElseThrow( ()->{throw new EntityNotFoundException("entity with id " + questionnaire_id + " not found");
        } );
    }
}
