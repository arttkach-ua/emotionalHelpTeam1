package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.mappers.QuestionnaireDtoMapper;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import com.epam.team1.emotional.help.util.ErrorMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionnaireService {
    private final QuestionnaireDtoMapper questionnaireDtoMapper;
    private final QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    public List<QuestionnaireDto> findAllDto() {
        log.info("Call of QuestionnaireService.findAllDto method.");
        List<Questionnaire> questionnaires = findAll();
        return questionnaires.stream()
                .map(questionnaireDtoMapper::toDTO)
                .toList();
    }

    public QuestionnaireDto create(QuestionnaireDto dto) {
        log.info("Call of QuestionnaireService.findAllDto method. dto is {}", dto);
        Questionnaire questionnaire = questionnaireDtoMapper.fromDto(dto);
        return questionnaireDtoMapper.toDTO(questionnaireRepository.save(questionnaire));
    }
    public Questionnaire getById(Long id){
        log.info("Call of MailService.send method. Params: id {}", id);
        return questionnaireRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format(ErrorMessages.QUESTIONNAIRE_NOT_FOUND, id)));
    }
}