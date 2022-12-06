package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.model.Specialist;
import com.epam.team1.emotional.help.service.SpecialistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/specialists")
@CrossOrigin
public class SpecialistsController {

    @Autowired
    private SpecialistsService specialistsService;

    @GetMapping
    public List<SpecialistResponseDto> getAllSpecialists(){
        return specialistsService.getAll();
    }
    @PostMapping
    public SpecialistResponseDto createSpecialist(@Valid@RequestBody SpecialistRequestDto dto){
        return specialistsService.create(dto);
    }
}
