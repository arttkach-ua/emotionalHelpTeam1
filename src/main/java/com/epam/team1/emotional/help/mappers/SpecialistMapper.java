package com.epam.team1.emotional.help.mappers;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.model.Specialist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class is used to store methods that will map Specialist entity to or from dto
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SpecialistMapper {
    @Value("${hosting.path}")
    private String path;

    /**
     * maps {@link SpecialistRequestDto} to {@link Specialist} entity
     * @param dto - {@link SpecialistRequestDto}
     * @return {@link Specialist}
     */
    public Specialist toSpecialist(SpecialistRequestDto dto){
        log.info("Call of SpecialistMapper.toSpecialist method. Params: dto {}", dto);
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
        log.info("Call of SpecialistMapper.mapToResponseDto method. Params: specialist {}", specialist);
        return SpecialistResponseDto.builder()
                .id(specialist.getId())
                .name(specialist.getName())
                .info(specialist.getInfo())
                .image(path + specialist.getImage())
                .build();
    }

    /**
     * maps List of {@link Specialist} entity to list of {@link SpecialistResponseDto}
     * @param  specialists - List of {@link Specialist}
     * @return list of {@link SpecialistResponseDto}
     */
    public List<SpecialistResponseDto> toSpecialistResponseDtoList(List<Specialist> specialists) {
        log.info("Call of SpecialistMapper.toSpecialistResponseDtoList method. Params: specialists {}", specialists);
        return specialists.stream()
                .map(this::mapToResponseDto)
                .toList();
    }
}
