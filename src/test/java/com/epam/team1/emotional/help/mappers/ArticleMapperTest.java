package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.dto.article.ArticleRequestDto;
import com.epam.team1.emotional.help.dto.article.ArticleResponseDto;
import com.epam.team1.emotional.help.model.Article;
import com.epam.team1.emotional.help.model.Specialist;
import com.epam.team1.emotional.help.providers.ArticlesDataProvider;
import com.epam.team1.emotional.help.providers.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void testToArticle() {
        ArticleRequestDto dto = ArticlesDataProvider.getSingleArticleRequestDtoForTests();
        Article article = articleMapper.toArticle(dto);
        assertEquals("some title", article.getTitle());
        assertEquals("some description", article.getDescription());
        assertEquals("some full description", article.getFullDescription());
        assertNotNull(article.getCreationDate());
    }

    @Test
    void testToArticleResponseDto() {
        Article article = ArticlesDataProvider.getSingleArticleForTests();
        ArticleResponseDto resultDto = articleMapper.toArticleResponseDto(article);
        assertEquals(article.getId(), resultDto.getId());
        assertEquals(article.getTitle(), resultDto.getTitle());
        assertEquals(article.getDescription(), resultDto.getDescription());
        assertEquals(article.getFullDescription(), resultDto.getFullDescription());
        assertEquals(article.getCreationDate(), resultDto.getCreationDate());
    }

    @Test
    void testToArticleResponseDtoList() {
        List<Article> articleList = ArticlesDataProvider.getArticleListForTests();
        List<ArticleResponseDto> resultList = articleMapper.toArticleResponseDtoList(articleList);

        assertEquals(resultList.size(),articleList.size());
        assertEquals(1L, resultList.get(0).getId());
        assertEquals(2L, resultList.get(1).getId());
    }
}