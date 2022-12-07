package com.epam.team1.emotional.help.dto.article;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String description;
    private String fullDescription;
    private Date creationDate;
}
