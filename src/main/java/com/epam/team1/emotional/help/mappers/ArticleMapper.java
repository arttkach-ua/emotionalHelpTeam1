package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.article.ArticleRequestDto;
import com.epam.team1.emotional.help.dto.article.ArticleResponseDto;
import com.epam.team1.emotional.help.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Component
public class ArticleMapper {
    /**
     * maps {@link ArticleRequestDto} to {@link Article} entity
     * @param dto - {@link ArticleRequestDto}
     * @return {@link Article}
     */
    public Article toArticle(ArticleRequestDto dto){
        log.info("Call of ArticleMapper.toArticle method. Params: dto , {}", dto);
        return Article.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .fullDescription(dto.getFullDescription())
                .creationDate(LocalDateTime.now())
                .build();
    }
    /**
     * maps {@link Article} entity to {@link ArticleResponseDto}
     * @param article {@link Article} entity
     * @return - {@link ArticleResponseDto}
     */
    public ArticleResponseDto toArticleResponseDto(Article article){
        log.info("Call of ArticleMapper.toArticleResponseDto method. Params: article , {}", article);
        return ArticleResponseDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .fullDescription(article.getFullDescription())
                .creationDate(article.getCreationDate())
                .build();
    }
    /**
     * maps List of {@link Article} entity to list of {@link ArticleResponseDto}
     * @param  articles - List of {@link Article}
     * @return list of {@link ArticleResponseDto}
     */
    public List<ArticleResponseDto> toArticleResponseDtoList(List<Article> articles) {
        log.info("Call of ArticleMapper.toArticleResponseDtoList method. Params: article , {}", articles);
        return articles.stream()
                .map(this::toArticleResponseDto)
                .toList();
    }
}
