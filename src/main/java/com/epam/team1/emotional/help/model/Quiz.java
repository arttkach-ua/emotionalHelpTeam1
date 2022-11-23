package com.epam.team1.emotional.help.model;

import lombok.*;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Quiz {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    @Column(name = "name", nullable = false, unique = true)
    String name;

//    @Column(name = "description")
    String description;
}
