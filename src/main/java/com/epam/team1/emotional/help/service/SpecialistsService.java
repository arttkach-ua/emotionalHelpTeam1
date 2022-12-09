package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.mappers.SpecialistMapper;
import com.epam.team1.emotional.help.model.Specialist;
import com.epam.team1.emotional.help.repository.SpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialistsService {
    private final SpecialistMapper specialistMapper;
    private final SpecialistRepository specialistRepository;

    public SpecialistResponseDto create(SpecialistRequestDto dto){
        Specialist specialist = specialistRepository.save(specialistMapper.toSpecialist(dto));
        return specialistMapper.mapToResponseDto(specialist);
    }
    public List<SpecialistResponseDto> getAll(){
        List<Specialist> specialists = specialistRepository.findAll();
        return specialistMapper.toSpecialistResponseDtoList(specialists);
    }
}
