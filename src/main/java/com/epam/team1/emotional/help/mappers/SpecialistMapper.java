package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.model.Specialist;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class is used to store methods that will map Specialist entity to or from dto
 */
@Component
public class SpecialistMapper {
    /**
     * maps {@link SpecialistRequestDto} to {@link Specialist} entity
     * @param dto - {@link SpecialistRequestDto}
     * @return {@link SpecialistRequestDto}
     */
    public Specialist toSpecialist(SpecialistRequestDto dto){
        return Specialist.builder()
                .info(dto.getInfo())
                .name(dto.getName())
                .image(dto.getImage())
                .build();
    }

    /**
     * maps {@link Specialist} entity to {@link SpecialistResponseDto}
     * @param specialist {@link Specialist} entity
     * @return - {@link SpecialistResponseDto}
     */
    public SpecialistResponseDto mapToResponseDto(Specialist specialist){
        return SpecialistResponseDto.builder()
                .id(specialist.getId())
                .name(specialist.getName())
                .info(specialist.getInfo())
                .image(specialist.getImage())
                .build();
    }

    /**
     * maps List of {@link Specialist} entity to list of {@link SpecialistResponseDto}
     * @param  specialists - List of {@link Specialist}
     * @return list of {@link SpecialistResponseDto}
     */
    public List<SpecialistResponseDto> toSpecialistResponseDtoList(List<Specialist> specialists) {
        return specialists.stream()
                .map(this::mapToResponseDto)
                .toList();
    }
}
