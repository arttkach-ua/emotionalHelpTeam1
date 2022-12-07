package com.epam.team1.emotional.help.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "access_code")
@Getter
@Setter
public class AccessCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private LocalDateTime createdAt;

    public AccessCode() {
    }

    public AccessCode(Long id, String code, LocalDateTime createdAt) {
        this.id = id;
        this.code = code;
        this.createdAt = createdAt;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessCode that = (AccessCode) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, createdAt);
    }
}
