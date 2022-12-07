package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.article.ArticleRequestDto;
import com.epam.team1.emotional.help.dto.article.ArticleResponseDto;
import com.epam.team1.emotional.help.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<ArticleResponseDto> getAll(){
        return articleService.getAll();
    }
    @GetMapping("/{id}")
    public ArticleResponseDto getSingleArticle(@PathVariable("id") Long id){
        return articleService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponseDto create(@Valid @RequestBody ArticleRequestDto dto){
        return articleService.create(dto);
    }
}