package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.model.AccessCode;
import com.epam.team1.emotional.help.repository.AccessCodeRepository;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.dto.request.SignupUserRequestDTO;
import com.epam.team1.emotional.help.dto.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Value;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final AccessCodeRepository accessCodeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final MailService mailService;
    private final UserMapper userMapper;

    @Value("${spring.mail.confirmLinkIP}")
    private String confirmLinkIP;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public MessageResponse confirmEmail(String code) {
        AccessCode accesscode = accessCodeRepository.findByCode(code).orElseThrow(() -> new NotFoundException("you have entered an invalid access code"));
        User user = userRepository.findByAccessCodeId(accesscode.getId()).orElseThrow(() -> new NotFoundException("Code does not exist"));
        user.setEnabled(true);
        user.setAccessCode(null);
        userRepository.save(user);
        accessCodeRepository.deleteById(accesscode.getId());
        return new MessageResponse("Your email has been successfully confirmed, now you can login to your account");
    }

    public User saveUser(SignupUserRequestDTO signupUserRequestDTO) {
        System.out.println("SignupService saveUser");
        User user = userMapper.mapToEntity(signupUserRequestDTO);
        user.setPassword(encoder.encode(user.getPassword()));
        String code = mailService.generateCode();
        user.setAccessCode(generateAccessCode(user,code));
        User userResp = userRepository.save(user);
        sendEmail(user.getEmail(), code);
        return userResp;
    }

    private void sendEmail(String email, String code) {
         String subject = "Here is your verification link";
         String confirmLink = confirmLinkIP + "signup/confirm-email/" + code;
         String mailText = "Click on this link to confirm your email \n" + confirmLink;
         mailService.send(email, subject, mailText);
    }

    private AccessCode generateAccessCode(User user, String code) {
        AccessCode accessCode = user.getAccessCode();
        if (accessCode != null) {
            AccessCode byId = accessCodeRepository.findById(accessCode.getId()).orElseThrow(()->new NotFoundException("Code does not exist"));
            byId.setCode(code);
            byId.setCreatedAt(LocalDateTime.now());
            return accessCodeRepository.save(byId);
        } else {
            accessCode = new AccessCode();
            accessCode.setCode(code);
        }
        accessCode.setCreatedAt(LocalDateTime.now());
        accessCodeRepository.save(accessCode);
        return accessCode;
    }

}
