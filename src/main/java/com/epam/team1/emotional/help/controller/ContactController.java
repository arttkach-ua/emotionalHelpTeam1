package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.CallRequestDto;
import com.epam.team1.emotional.help.dto.ConsultationRequestDto;
import com.epam.team1.emotional.help.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
@CrossOrigin
public class ContactController {
    @Autowired
    private MailService mailService;

    @GetMapping("/callRequest")
    public String callRequest(@Valid @RequestBody CallRequestDto dto){
        mailService.sendCallRequestMail(dto);
        return "success";
    }
    @GetMapping("/consultationRequest")
    public String consultationRequest(@Valid @RequestBody ConsultationRequestDto dto){
        mailService.sendConsultationRequestMail(dto);
        return "success";
    }
}
