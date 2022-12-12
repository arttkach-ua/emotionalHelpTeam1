package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.*;
import com.epam.team1.emotional.help.exception.ErrorResponse;
import com.epam.team1.emotional.help.model.User;
import com.epam.team1.emotional.help.service.AuthService;
import com.epam.team1.emotional.help.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public @ResponseStatus(HttpStatus.OK) LoginResponseDTO loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        log.info("user tries to login with username {} ", loginRequest.getUsername());
        return authService.loginUser(loginRequest);
    }


    @PostMapping("/refresh-token")
    public TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest) {
        //log.info();
        String userMail = userService.getCurrentUser().orElseThrow(
                () -> new RuntimeException("user not found")).getEmail();
        log.info("User with email {} sent refresh token request", userMail);
        return authService.refreshToken(httpServletRequest);
    }


    @PostMapping("/reset-password")
    public MessageResponse resetPassword(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        String userMail = userService.getCurrentUser().orElseThrow(
                () -> new RuntimeException("user not found")).getEmail();
        log.info("user with email {} sent reset password request", userMail);
        return authService.resetPassword(passwordResetRequest);
    }

    @PostMapping("/send-verification-code-to-mail")
    public void sendMail(@RequestParam("email") String email) {
        authService.sendEmail(email);
        log.info("mail verification code is sent to the mail  {}", email);
    }

    @PostMapping("/reset-forgotten-password")
    public void resetForgottenPassword(@Valid @RequestBody ForgotPasswordRequestDTO forgotPasswordDTO) {
        String userMail = userService.getCurrentUser().orElseThrow(
                () -> new RuntimeException("user not found")).getEmail();
        authService.resetForgottenPassword(forgotPasswordDTO);
        log.info("forgotten password has bean reset for the user {}.", userMail);
    }

    @ExceptionHandler()
    protected ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(400,
                exception.getMessage(),
                System.currentTimeMillis(),
                exception.getClass().getSimpleName(),
                request.getDescription(false)
        );
        log.error("Exception message {}, exception type {},"
                , exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}