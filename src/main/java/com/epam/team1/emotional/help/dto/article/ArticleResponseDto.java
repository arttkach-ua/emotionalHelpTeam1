package com.epam.team1.emotional.help.dto.article;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String description;
    private String fullDescription;
    private LocalDateTime creationDate;
}
