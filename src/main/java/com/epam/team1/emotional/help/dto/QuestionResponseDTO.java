package com.epam.team1.emotional.help.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionResponseDTO {

    private Long id;
    private String question;
    private List<AnswerResponseDTO> answers;
}
