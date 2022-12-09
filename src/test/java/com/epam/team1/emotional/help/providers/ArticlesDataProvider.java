package com.epam.team1.emotional.help.providers;

import com.epam.team1.emotional.help.dto.article.ArticleRequestDto;
import com.epam.team1.emotional.help.model.Article;

import java.util.List;

public class ArticlesDataProvider {
    public static List<Article> getArticleListForTests(){
        return List.of(
                Article.builder().id(1L).title("some title 1").description("some description 1").fullDescription("some full description 1").build(),
                Article.builder().id(2L).title("some title 2").description("some description 2").fullDescription("some full description 2").build());
    }
    public static Article getSingleArticleForTests(){
        return Article.builder()
                .id(1L)
                .title("some title 1")
                .description("some description 1")
                .fullDescription("some full description 1")
                .build();
    }
    public static ArticleRequestDto getSingleArticleRequestDtoForTests(){
        return ArticleRequestDto.builder()
                .title("some title")
                .description("some description")
                .fullDescription("some full description")
                .build();
    }
}
