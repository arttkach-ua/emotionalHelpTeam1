package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.dto.CallRequestDto;
import com.epam.team1.emotional.help.dto.ConsultationRequestDto;
import com.epam.team1.emotional.help.dto.SendQuizResultToEmailDto;
import com.epam.team1.emotional.help.util.MailMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${mail.contactorMail}")
    private String contactorMail;

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

    public void sendCallRequestMail(CallRequestDto dto){

        send(contactorMail,
                String.format(MailMessages.CALL_ME_MAIL_THEME, dto.getName()),
                String.format(MailMessages.CALL_ME_MAIL_BODY, dto.getName(), dto.getPhoneNumber()));
    }
    public void sendConsultationRequestMail(ConsultationRequestDto dto){

        send(contactorMail,
                String.format(MailMessages.CONSULTATION_REQUEST_MAIL_THEME, dto.getName()),
                String.format(MailMessages.CONSULTATION_REQUEST_MAIL_BODY, dto.getName(), dto.getPhoneNumber(), (dto.getDate().toString())));
    }
    public void sendQuizResultToMail(SendQuizResultToEmailDto dto){
        send(dto.getEmail(),
                MailMessages.QUIZ_RESULT_MAIL_THEME,
                String.format(MailMessages.QUIZ_RESULT_MAIL_BODY, dto.getName(),dto.getDescription()));
    }
}
