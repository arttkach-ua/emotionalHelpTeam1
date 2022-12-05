package com.epam.team1.emotional.help.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testController")
@CrossOrigin
public class TestController {

    @GetMapping("/access-only-user")
    public String test(){
        return "hello";
    }
}
