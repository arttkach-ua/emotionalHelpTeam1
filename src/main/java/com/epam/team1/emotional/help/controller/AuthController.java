package com.epam.team1.emotional.help.controller;

import com.epam.team1.emotional.help.dto.TokenRefreshResponseDTO;
import com.epam.team1.emotional.help.exception.ErrorResponse;
import com.epam.team1.emotional.help.dto.ForgotPasswordRequestDTO;
import com.epam.team1.emotional.help.dto.LoginRequestDTO;
import com.epam.team1.emotional.help.dto.PasswordResetRequest;
import com.epam.team1.emotional.help.dto.LoginResponseDTO;
import com.epam.team1.emotional.help.dto.MessageResponse;
import com.epam.team1.emotional.help.service.AuthService;
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

    @PostMapping("/login")
    public @ResponseStatus(HttpStatus.OK) LoginResponseDTO loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        return authService.loginUser(loginRequest);
    }


    @PostMapping("/refresh-token")
    public TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest) {
        TokenRefreshResponseDTO tokenRefreshResponseDTO = authService.refreshToken(httpServletRequest);
        return tokenRefreshResponseDTO;
    }


    @PostMapping("/reset-password")
    public MessageResponse resetPassword(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        MessageResponse messageResponse = authService.resetPassword(passwordResetRequest);
        return messageResponse;
    }

    @PostMapping("/send-verification-code-to-mail")
    public void sendMail(@RequestParam("email") String email) {
        authService.sendEmail(email);
        log.error("mail is sent to " + email);
    }

    @PostMapping("/reset-forgotten-password")
    public void resetForgottenPassword(@Valid @RequestBody ForgotPasswordRequestDTO forgotPasswordDTO) {
        authService.resetForgottenPassword(forgotPasswordDTO);
        log.error("forgotten password has bean reset , access code is " + forgotPasswordDTO.getCode());
    }

    @ExceptionHandler()
    protected ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest request) {
        log.error("MethodArgumentNotValidException handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());

        ErrorResponse errorResponse = new ErrorResponse(400,
                exception.getMessage(),
                System.currentTimeMillis(),
                exception.getClass().getSimpleName(),
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

}