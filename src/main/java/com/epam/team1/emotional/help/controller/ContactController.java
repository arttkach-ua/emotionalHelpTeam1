package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.CallRequestDto;
import com.epam.team1.emotional.help.dto.ConsultationRequestDto;
import com.epam.team1.emotional.help.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
@CrossOrigin
public class ContactController {
    private final MailService mailService;

    @GetMapping("/callRequest")
    public void callRequest(@Valid @RequestBody CallRequestDto dto){
        mailService.sendCallRequestMail(dto);
    }
    @GetMapping("/consultationRequest")
    public void consultationRequest(@Valid @RequestBody ConsultationRequestDto dto){
        mailService.sendConsultationRequestMail(dto);
    }
}
