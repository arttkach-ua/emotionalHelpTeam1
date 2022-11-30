//package com.epam.team1.emotional.help.mappers;
//
//import com.epam.team1.emotional.help.dto.QuestionResponseDTO;
//import com.epam.team1.emotional.help.dto.QuestionnaireResponseDTO;
//import com.epam.team1.emotional.help.model.Question;
//import com.epam.team1.emotional.help.model.Questionnaire;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class QuestionnaireMapper {
//
//    private final QuestionMapper questionMapper;
//
//    public QuestionnaireMapper(QuestionMapper questionMapper) {
//        this.questionMapper = questionMapper;
//    }
//
//    public QuestionnaireResponseDTO mapToResponseDto(Questionnaire questionnaire) {
//        QuestionnaireResponseDTO questionnaireResponseDTO = new QuestionnaireResponseDTO();
//        questionnaireResponseDTO.setId(questionnaire.getId());
//        questionnaireResponseDTO.setName(questionnaire.getName());
//        questionnaireResponseDTO.setDescription(questionnaire.getDescription());
//        questionnaireResponseDTO.setQuestions(mapAll(questionnaire.getQuestionList()));
//        return questionnaireResponseDTO;
//    }
//
//    private List<QuestionResponseDTO> mapAll(List<Question> questions) {
//        return questions.stream().map(questionMapper::mapToResponseDto).collect(Collectors.toList());
//    }
//}
