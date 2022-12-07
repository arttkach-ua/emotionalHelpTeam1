package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
public class ResultsController {

    @PostMapping
    public String addResult(@RequestBody ResultRequestDto dto){
        //todo finish it
        return "in progress";
    }
}