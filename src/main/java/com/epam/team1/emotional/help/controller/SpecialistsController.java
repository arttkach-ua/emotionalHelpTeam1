package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.Specialist.SpecialistRequestDto;
import com.epam.team1.emotional.help.dto.Specialist.SpecialistResponseDto;
import com.epam.team1.emotional.help.service.SpecialistsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/specialists")
@CrossOrigin
public class SpecialistsController {

    @Autowired
    private SpecialistsService specialistsService;

    @GetMapping
    public List<SpecialistResponseDto> getAllSpecialists(){
        log.info("Call of /results endpoint.(Get method).");
        return specialistsService.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialistResponseDto createSpecialist(@Valid @RequestBody SpecialistRequestDto dto){
        log.info("Call of /specialists endpoint.(Post method). dto is {}", dto);
        return specialistsService.create(dto);
    }
}
