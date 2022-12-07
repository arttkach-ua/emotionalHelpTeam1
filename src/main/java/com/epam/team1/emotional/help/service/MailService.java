package com.epam.team1.emotional.help.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void send(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("iemotionalhelpteam1@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSubject(subject);

        Thread thread = new Thread(() -> javaMailSender.send(simpleMailMessage));
        thread.start();
    }

    public String generateCode() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid);
    }

}
