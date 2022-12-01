package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.mappers.QuestionnaireDtoMapper;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
import com.epam.team1.emotional.help.util.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionnaireService {
    @Autowired
    private QuestionnaireDtoMapper questionnaireDtoMapper;
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    public List<QuestionnaireDto> findAllDto() {
        List<Questionnaire> questionnaires = findAll();
        return questionnaires.stream()
                .map(questionnaireDtoMapper::toDTO)
                .toList();
    }

    public QuestionnaireDto create(QuestionnaireDto dto) {
        //TODO add validation before create
        Questionnaire questionnaire = questionnaireDtoMapper.fromDto(dto);
        return questionnaireDtoMapper.toDTO(questionnaireRepository.save(questionnaire));
    }
    public Questionnaire getById(Long id){
        return questionnaireRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format(ErrorMessages.QUESTIONNAIRE_NOT_FOUND, id)));
    }
}
