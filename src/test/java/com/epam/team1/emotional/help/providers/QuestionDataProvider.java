//package com.epam.team1.emotional.help.providers;
//
//import com.epam.team1.emotional.help.dto.QuestionRequestDto;
//import com.epam.team1.emotional.help.model.Question;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//
//import java.util.ArrayList;
//import java.util.stream.Stream;
//
//public class QuestionDataProvider implements ArgumentsProvider {
//       public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
//            return Stream.of(
//                    Arguments.of(new QuestionRequestDto(1L, "test question"),
//                            Question.builder()
//                            .id(1L)
//                            .name("test question")
//                            .questionnaire(TestDataProvider.getSingleQuestionnaireForTests())
//                            .answersList(new ArrayList<>())
//                            .build(), 1L, "test question"),
//                    Arguments.of(new QuestionRequestDto(2L, "test question2"),
//                            Question.builder()
//                            .id(2L)
//                            .name("test question2")
//                            .questionnaire(TestDataProvider.getSingleQuestionnaireForTests())
//                            .answersList(new ArrayList<>())
//                            .build(), 2L, "test question2")
//            );
//       }
//}
