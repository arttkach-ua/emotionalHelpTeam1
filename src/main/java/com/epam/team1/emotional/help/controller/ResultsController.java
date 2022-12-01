package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import com.epam.team1.emotional.help.dto.ResultResponseDto;
import com.epam.team1.emotional.help.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/results")
@CrossOrigin
public class ResultsController {
    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResultResponseDto addResult(@RequestBody ResultRequestDto dto){
        return resultService.create(dto);
    }
}
