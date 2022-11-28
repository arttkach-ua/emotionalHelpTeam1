//package com.epam.team1.emotional.help.service;
//
//import com.epam.team1.emotional.help.dto.QuestionnaireDto;
//import com.epam.team1.emotional.help.mappers.QuestionnaireDtoMapper;
//import com.epam.team1.emotional.help.model.Questionnaire;
//import lombok.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.epam.team1.emotional.help.reposithory.QuestionnaireRepository;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class QuestionnaireService {
//    @Autowired
//    QuestionnaireDtoMapper questionnaireDtoMapper;
//
//    @Autowired
//    QuestionnaireRepository questionnaireRepository;
//
//    public List<Questionnaire> findAll() {
//        return questionnaireRepository.findAll();
//    }
//
//    public List<QuestionnaireDto> findAllDto() {
//        List<Questionnaire> questionnaires = findAll();
//        List<QuestionnaireDto> quizzesDto = questionnaires.stream()
//                .map(a-> questionnaireDtoMapper.toDTO(a))
//                .toList();
//        return quizzesDto;
//    }
//
//    public Questionnaire create(QuestionnaireDto dto) {
//        //TODO add validation before create
//        Questionnaire questionnaire = questionnaireDtoMapper.fromDto(dto);
//        return questionnaireRepository.save(questionnaire);
//    }
//}
