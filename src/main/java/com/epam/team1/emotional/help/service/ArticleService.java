package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.article.ArticleRequestDto;
import com.epam.team1.emotional.help.dto.article.ArticleResponseDto;
import com.epam.team1.emotional.help.mappers.ArticleMapper;
import com.epam.team1.emotional.help.model.Article;
import com.epam.team1.emotional.help.repository.ArticleRepository;
import com.epam.team1.emotional.help.util.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

    public List<ArticleResponseDto> getAll(){
        return articleMapper.toArticleResponseDtoList(articleRepository.findAll());
    }

    public ArticleResponseDto create(ArticleRequestDto dto) {
        Article article = articleRepository.save(articleMapper.toArticle(dto));
        return articleMapper.toArticleResponseDto(article);
    }

    public ArticleResponseDto getById(Long id) {
        return articleMapper.toArticleResponseDto(articleRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format(ErrorMessages.ARTICLE_NOT_FOUND, id))));
    }
}
