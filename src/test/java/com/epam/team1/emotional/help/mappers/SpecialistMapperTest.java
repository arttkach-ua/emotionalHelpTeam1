package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.model.Specialist;
import com.epam.team1.emotional.help.providers.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = { "hosting.path=testpath/" })
class SpecialistMapperTest {
    @Autowired
    private SpecialistMapper specialistMapper;

    @Test
    void testToSpecialist() {
        SpecialistRequestDto dto = TestDataProvider.getSingleSpecialistRequestDtoForTests();
        Specialist resultSpecialist = specialistMapper.toSpecialist(dto);
        assertEquals("some info", resultSpecialist.getInfo());
        assertEquals("some name", resultSpecialist.getName());
        assertEquals("some path", resultSpecialist.getImage());
        assertNull(resultSpecialist.getId());
    }

    @Test
    void testMapToResponseDto() {
        Specialist specialist = TestDataProvider.getSingleSpecialistForTests();
        SpecialistResponseDto resultDto = specialistMapper.mapToResponseDto(specialist);

        assertEquals("some info", resultDto.getInfo());
        assertEquals("some name", resultDto.getName());
        assertEquals("testpath/some path", resultDto.getImage());
        assertEquals(1L, resultDto.getId());

    }

    @Test
    void testToSpecialistResponseDtoList() {
        List<Specialist> specialistList = TestDataProvider.getSpecialistListForTests();
        List<SpecialistResponseDto> resultList = specialistMapper.toSpecialistResponseDtoList(specialistList);

        assertEquals(resultList.size(),specialistList.size());
        assertEquals(1L, resultList.get(0).getId());
        assertEquals(2L, resultList.get(1).getId());
    }
}