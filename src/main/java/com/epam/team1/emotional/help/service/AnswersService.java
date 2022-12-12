package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.model.Answer;
import com.epam.team1.emotional.help.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
@Slf4j
@Service
@RequiredArgsConstructor
public class AnswersService {
    private final AnswerRepository answerRepository;

    public Answer create(Answer dto){
        log.info("Call of AnswersService.create method. dto is {}", dto);
        return answerRepository.save(dto);
    }

    public Answer getById(Long id){
        log.info("Call of AnswersService.getById method. id is {}", id);
        return answerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
