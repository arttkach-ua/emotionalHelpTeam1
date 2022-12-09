package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.dto.SignupConformedResponseDto;
import com.epam.team1.emotional.help.dto.SignupResponseDTO;
import com.epam.team1.emotional.help.dto.UserResponseDTO;
import com.epam.team1.emotional.help.exception.ConformationCodeIsBlankException;
import com.epam.team1.emotional.help.exception.EmailAlreadyExistsException;
import com.epam.team1.emotional.help.mappers.SignupMapper;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.model.AccessCode;
import com.epam.team1.emotional.help.repository.AccessCodeRepository;
import com.epam.team1.emotional.help.mappers.UserMapper;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.dto.SignupUserRequestDTO;
import com.epam.team1.emotional.help.security.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Value;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignupService {

    private final SignupMapper signupMapper;
    private final AccessCodeRepository accessCodeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final MailService mailService;
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;

    @Value("${spring.mail.confirmLinkIP}")
    private String confirmLinkIP;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public SignupConformedResponseDto confirmEmail(String code) {
        if (code.isBlank()){throw new ConformationCodeIsBlankException("you sent a blank message");}
        AccessCode accesscode = accessCodeRepository.findByCode(code).orElseThrow(() -> new NotFoundException("you have entered an invalid access code"));
        User user = userRepository.findByAccessCodeId(accesscode.getId()).orElseThrow(() -> new NotFoundException("Code does not exist"));
        user.setEnabled(true);
        user.setAccessCode(null);
        userRepository.save(user);
        accessCodeRepository.deleteById(accesscode.getId());
        String jwtAccess = jwtUtils.generateJwtToken(user.getEmail());
        UserResponseDTO userResponseDTO = userMapper.mapToResponseDto(user);
        log.error("success email conformation with code " + code);
        return new SignupConformedResponseDto(jwtAccess, userResponseDTO);
    }

    public SignupResponseDTO saveUser(SignupUserRequestDTO signupUserRequestDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(signupUserRequestDTO.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("the provided email address already exists");
        }
        User user = userMapper.mapToEntity(signupUserRequestDTO);
        user.setPassword(encoder.encode(user.getPassword()));
        String code = mailService.generateCode();
        user.setAccessCode(generateAccessCode(user, code));
        User userResp = userRepository.save(user);
        sendEmail(user.getEmail(), code);
        return signupMapper.mapToResponseDto(userResp);
    }

    private void sendEmail(String email, String code) {
        String subject = "Here is your verification link";
        String confirmLink = confirmLinkIP + "confirm/" + code;
        String mailText = "Click on this link to confirm your email \n" + confirmLink;
        mailService.send(email, subject, mailText);
    }

    private AccessCode generateAccessCode(User user, String code) {
        AccessCode accessCode = user.getAccessCode();
        if (accessCode != null) {
            AccessCode providedAccessCode = accessCodeRepository.findById(accessCode.getId()).orElseThrow(() -> new NotFoundException("Code does not exist"));
            providedAccessCode.setCode(code);
            providedAccessCode.setCreatedAt(LocalDateTime.now());
            return accessCodeRepository.save(providedAccessCode);
        } else {
            accessCode = new AccessCode();
            accessCode.setCode(code);
        }
        accessCode.setCreatedAt(LocalDateTime.now());
        accessCodeRepository.save(accessCode);
        return accessCode;
    }

}