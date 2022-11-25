package com.epam.team1.emotional.help.model;

import com.epam.team1.emotional.help.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "answer")
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
public class Answer extends BaseEntity {

    @NotNull
    @Column(name = "answer", nullable = false, unique = true)
    private String answer;

    @NotNull
    @Column(name = "point", nullable = false, unique = false)
    private int point;
}
