package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.model.Specialist;
import com.epam.team1.emotional.help.providers.TestDataProvider;
import com.epam.team1.emotional.help.repository.SpecialistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class SpecialistsServiceTest {
    @Autowired
    private SpecialistsService specialistsService;
    @MockBean
    private SpecialistRepository specialistRepository;

    @Test
    void testCreate() {
        SpecialistRequestDto requestDto = TestDataProvider.getSingleSpecialistRequestDtoForTests();
        when(specialistRepository.save(any(Specialist.class)))
                .thenReturn(TestDataProvider.getSingleSpecialistForTests());
        SpecialistResponseDto resultDto = specialistsService.create(requestDto);
        assertEquals(1L, resultDto.getId());
        assertEquals("some name", resultDto.getName());
        assertEquals("some info", resultDto.getInfo());
        assertEquals("some path", resultDto.getImage());
        verify(specialistRepository,times(1)).save(any(Specialist.class));
    }

    @Test
    void testGetAll() {
        when(specialistRepository.findAll())
                .thenReturn(TestDataProvider.getSpecialistListForTests());
        List<SpecialistResponseDto> resultList = specialistsService.getAll();
        assertEquals(2, resultList.size());
        assertEquals(1L, resultList.get(0).getId());
        assertEquals(2L, resultList.get(1).getId());
        verify(specialistRepository,times(1)).findAll();
    }
}