package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/results")
public class ResultsController {
    @Autowired
    private ResultService resultService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultResponseDto addResult(@Valid @RequestBody ResultRequestDto dto){
        return resultService.create(dto);
    }
}
