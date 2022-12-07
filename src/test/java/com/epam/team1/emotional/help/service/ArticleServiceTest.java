//package com.epam.team1.emotional.help.service;
//
//import com.epam.team1.emotional.help.dto.article.ArticleRequestDto;
//import com.epam.team1.emotional.help.dto.article.ArticleResponseDto;
//import com.epam.team1.emotional.help.model.Article;
//import com.epam.team1.emotional.help.providers.ArticlesDataProvider;
//import com.epam.team1.emotional.help.repository.ArticleRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class ArticleServiceTest {
//
//    @Autowired
//    private ArticleService articleService;
//    @MockBean
//    private ArticleRepository mockedArticleRepository;
//
//    @Test
//    void testGetAll() {
//        when(mockedArticleRepository.findAll())
//                .thenReturn(ArticlesDataProvider.getArticleListForTests());
//        List<ArticleResponseDto> resultList = articleService.getAll();
//        assertEquals(2, resultList.size());
//        assertEquals(1L, resultList.get(0).getId());
//        assertEquals(2L, resultList.get(1).getId());
//        verify(mockedArticleRepository,times(1)).findAll();
//    }
//
//    @Test
//    void testCreate() {
//        ArticleRequestDto requestDto = ArticlesDataProvider.getSingleArticleRequestDtoForTests();
//        when(mockedArticleRepository.save(any(Article.class)))
//                .thenReturn(ArticlesDataProvider.getSingleArticleForTests());
//        ArticleResponseDto resultDto = articleService.create(requestDto);
//        assertEquals(1L, resultDto.getId());
//        assertEquals("some title 1", resultDto.getTitle());
//        assertEquals("some description 1", resultDto.getDescription());
//        assertEquals("some full description 1", resultDto.getFullDescription());
//        verify(mockedArticleRepository,times(1)).save(any(Article.class));
//    }
//
//    @Test
//    void testGetByIdEntityIsFound() {
//        Article testArticle = ArticlesDataProvider.getSingleArticleForTests();
//        when(mockedArticleRepository.findById(any(Long.class)))
//                .thenReturn(Optional.of(testArticle));
//
//        ArticleResponseDto result = articleService.getById(1L);
//        assertEquals("some title 1", result.getTitle());
//        assertEquals("some description 1", result.getDescription());
//        assertEquals(1L, result.getId());
//    }
//
//    @Test
//    void testGetByIdEntityNotFound() {
//        when(mockedArticleRepository.findById(anyLong()))
//                .thenReturn(Optional.empty());
//
//        Exception ex = assertThrows(EntityNotFoundException.class,()->articleService.getById(1L));
//        assertEquals("Article with id 1 not found", ex.getMessage());
//    }
//}