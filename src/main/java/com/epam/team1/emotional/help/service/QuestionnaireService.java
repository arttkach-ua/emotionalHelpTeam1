package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.QuestionnaireDto;
import com.epam.team1.emotional.help.mappers.QuestionnaireDtoMapper;
import com.epam.team1.emotional.help.model.Questionnaire;
import com.epam.team1.emotional.help.repository.QuestionnaireRepository;
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
    QuestionnaireDtoMapper questionnaireDtoMapper;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    public List<QuestionnaireDto> findAllDto() {
        List<Questionnaire> questionnaires = findAll();
        return questionnaires.stream()
                .map(a-> questionnaireDtoMapper.toDTO(a))
                .toList();
    }

    public Questionnaire create(QuestionnaireDto dto) {
        //TODO add validation before create
        Questionnaire questionnaire = questionnaireDtoMapper.fromDto(dto);
        return questionnaireRepository.save(questionnaire);
    }
    public Questionnaire getById(long id){
        //TODO fix this bug
        return questionnaireRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("Questionnaire with id %c not found", id)));
    }
}
