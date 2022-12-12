package com.epam.team1.emotional.help.service;


import com.epam.team1.emotional.help.dto.ForgotPasswordRequestDTO;
import com.epam.team1.emotional.help.dto.LoginRequestDTO;
import com.epam.team1.emotional.help.dto.PasswordResetRequest;
import com.epam.team1.emotional.help.dto.LoginResponseDTO;
import com.epam.team1.emotional.help.dto.MessageResponse;
import com.epam.team1.emotional.help.dto.TokenRefreshResponseDTO;
import com.epam.team1.emotional.help.exception.IncorrectCurrentPasswordException;
import com.epam.team1.emotional.help.mappers.LoginMapper;
import com.epam.team1.emotional.help.model.AccessCode;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.repository.AccessCodeRepository;
import com.epam.team1.emotional.help.repository.UserRepository;
import com.epam.team1.emotional.help.security.UserDetailsImplementation;
import com.epam.team1.emotional.help.security.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    private final AccessCodeRepository accessCodeRepository;
    private final LoginMapper loginMapper;

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImplementation userDetailsImplementation = (UserDetailsImplementation) authentication.getPrincipal();
        String jwtAccess = jwtUtils.generateJwtToken(userDetailsImplementation, false);
        String jwtRefresh = jwtUtils.generateJwtToken(userDetailsImplementation, true);

        log.info("user with userName {} is logged in successfully" , loginRequest.getUsername());
        return new LoginResponseDTO(jwtAccess, jwtRefresh,
                loginMapper.mapToResponseDto(userDetailsImplementation.getUser()));
    }

    public TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest) {
        String requestJwtRefresh = jwtUtils.parseJwt(httpServletRequest);
        UserDetailsImplementation userDetailsImplementation = (UserDetailsImplementation) userDetailsServiceImplementation.loadUserByUsername(
                jwtUtils.getUserNameFromJwtToken(requestJwtRefresh));

        String jwtAccess = jwtUtils.generateJwtToken(userDetailsImplementation, false);
        String jwtRefresh = jwtUtils.generateJwtToken(userDetailsImplementation, true);
        log.info("successfully jwt refresh for the user with username {}, and with refresh token {} ,  and with refresh token {}"
                , getUserDetails().getUsername()
                , jwtAccess , jwtRefresh);
        return new TokenRefreshResponseDTO(jwtAccess, jwtRefresh);
    }

    public MessageResponse resetPassword(PasswordResetRequest passwordResetRequest) {
        if (!passwordResetRequest.getNewPassword().equals(passwordResetRequest.getConformNewPassword())) {
            throw new RuntimeException("Password and confirm_password do not match");
        }
        UserDetails userDetails = getUserDetails();
        Optional<User> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (passwordEncoder.matches(passwordResetRequest.getCurrentPassword(), user.getPassword())) {

            user.setPassword(passwordEncoder.encode(passwordResetRequest.getNewPassword()));
            userRepository.save(user);
            log.info("successful password reset by a user with a username {}, , new password is {}" , getUserDetails().getUsername()
                    ,passwordResetRequest.getCurrentPassword());
        } else {
            log.error("user with the username {} provided an incorrect current password" , getUserDetails().getUsername());
            throw new IncorrectCurrentPasswordException("Incorrect password");
        }
        return new MessageResponse("Password reset was successful");
    }

    static UserDetailsImplementation getUserDetails() {
        return (UserDetailsImplementation) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public void sendEmail(String email) {
        User byEmail = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + "email does not exist"));
        String subject = "Your verification code ";
        String code = mailService.generateCode();

        if (byEmail.isEnabled() && !byEmail.isBlocked()) {
            if (byEmail.getAccessCode() != null) {
                mailService.send(email, subject, code);
                byEmail.getAccessCode().setCode(code);
                byEmail.getAccessCode().setCreatedAt(LocalDateTime.now());
                userRepository.save(byEmail);
            } else {
                mailService.send(email, subject, code);
                AccessCode accessCode = new AccessCode();
                accessCode.setCode(code);
                accessCode.setCreatedAt(LocalDateTime.now());
                byEmail.setAccessCode(accessCode);
                accessCodeRepository.save(accessCode);
                userRepository.save(byEmail);
            }
        } else {
            throw new RuntimeException("Account either not enabled or blocked");
        }
    }

    public void resetForgottenPassword(ForgotPasswordRequestDTO forgotPasswordRequestDTO) {
        AccessCode code = accessCodeRepository.findByCode(forgotPasswordRequestDTO.getCode()).orElseThrow(() -> new NotFoundException("Wrong code"));
        User byAccessCode = userRepository.findByAccessCodeId(code.getId()).orElseThrow(() -> new NotFoundException("Code does not exist"));
        if (forgotPasswordRequestDTO.getPassword().equals(forgotPasswordRequestDTO.getConfirmPassword())) {
            byAccessCode.setPassword(passwordEncoder.encode(forgotPasswordRequestDTO.getPassword()));
            byAccessCode.setAccessCode(null);
            userRepository.save(byAccessCode);
        } else {
            throw new RuntimeException("Password and confirm password do not match");
        }

    }


}
