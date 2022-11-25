package com.epam.team1.emotional.help.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
public class QuestionnaireResponseDTO {

    private Long id;
    private String name;
    private String description;
    private List<QuestionResponseDTO> questionResponseDTOList;
}
