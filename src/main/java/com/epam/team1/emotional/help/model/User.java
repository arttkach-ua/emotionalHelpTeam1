package com.epam.team1.emotional.help.model;


import com.epam.team1.emotional.help.model.enums.Gender;
import com.epam.team1.emotional.help.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String image;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    private LocalDateTime birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String country;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled = false;
    private boolean blocked = false;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_code_id", referencedColumnName = "id")
    private AccessCode accessCode;

}