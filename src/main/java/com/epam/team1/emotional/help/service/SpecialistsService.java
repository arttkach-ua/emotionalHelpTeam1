package com.epam.team1.emotional.help.service;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.mappers.SpecialistMapper;
import com.epam.team1.emotional.help.model.Specialist;
import com.epam.team1.emotional.help.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistsService {
    @Autowired
    private SpecialistMapper specialistMapper;
    @Autowired
    private SpecialistRepository specialistRepository;

    public SpecialistResponseDto create(SpecialistRequestDto dto){
        Specialist specialist = specialistRepository.save(specialistMapper.toSpecialist(dto));
        return specialistMapper.mapToResponseDto(specialist);
    }
    public List<SpecialistResponseDto> getAll(){
        List<Specialist> specialists = specialistRepository.findAll();
        return specialistMapper.toSpecialistResponseDtoList(specialists);
    }
}
