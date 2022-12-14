package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswersService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer create(Answer dto){
        return answerRepository.save(dto);
    }

}

