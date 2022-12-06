package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.ResultRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
@CrossOrigin
public class ResultsController {

    @PostMapping
    public String addResult(@RequestBody ResultRequestDto dto){
        //todo finish it
        return "in progress";
    }
}
