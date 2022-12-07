
package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.model.Result;
import com.epam.team1.emotional.help.providers.TestDataProvider;
import com.epam.team1.emotional.help.repository.ResultRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ResultServiceTest {
    @Autowired
    private ResultService resultService;

    @Autowired
    private QuestionnaireService questionnaireService;

    @MockBean
    private ResultRepository mockedResultRepository;

    @Test
    void testCreate() {
        ResultRequestDto dto = ResultRequestDto.builder()
                .points(25)
                .fullDescription("full")
                .shortDescription("short")
                .questionnaireId(1L)
                .build();

        when(mockedResultRepository.save(any(Result.class)))
                .thenReturn(TestDataProvider.getSingleResultForTests());

        ResultResponseDto resultEntity = resultService.create(dto);
        assertEquals("full", resultEntity.getFullDescription());
        assertEquals("short", resultEntity.getShortDescription());
        assertEquals(1L, resultEntity.getId());
        assertEquals(25, resultEntity.getPoints());
        assertEquals(1L, resultEntity.getQuestionnaireId());
    }
}
