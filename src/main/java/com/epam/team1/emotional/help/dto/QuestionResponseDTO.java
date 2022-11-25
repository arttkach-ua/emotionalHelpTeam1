package com.epam.team1.emotional.help.dto;

import com.epam.team1.emotional.help.model.Answer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/*
The data annotation includes the following
 @ToString,
 @EqualsAndHashCode,
 @Getter on all fields,
 @Setter on all non-final fields,
 @RequiredArgsConstructor
 */
@Data
@NoArgsConstructor
public class QuestionResponseDTO {

    private Long id;
    private String question;
    private List<AnswerResponseDTO> answerResponseDTOList;

}
