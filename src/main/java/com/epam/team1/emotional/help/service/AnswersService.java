package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AnswersService {
    private final AnswerRepository answerRepository;

    public Answer create(Answer dto){
        return answerRepository.save(dto);
    }

    public Answer getById(Long id){
        return answerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
