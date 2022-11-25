package com.epam.team1.emotional.help.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

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
public class AnswerResponseDTO {

    private Long id;
    private String answer;
    private int point;
}
