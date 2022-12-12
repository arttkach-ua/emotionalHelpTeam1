package com.epam.team1.emotional.help.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        setCommonData(exception, errorResponse, request);
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    private void setCommonData(Exception exception, ErrorResponse errorResponse, WebRequest request) {
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setException(exception.getClass().getName());
        errorResponse.setDetails(request.getDescription(false));
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleAll(Exception exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        setCommonData(exception, errorResponse, request);
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EmailAlreadyExistsException.class})
    protected ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.CONTINUE.value());
        setCommonData(exception, errorResponse, request);
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler({AuthenticationException.class})
    protected ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        setCommonData(exception,errorResponse,request);
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler({IOException.class})
    protected ResponseEntity<Object> handleIOException(IOException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.CONTINUE.value());
        setCommonData(exception,errorResponse,request);
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> handleIncorrectCurrentPasswordException(IncorrectCurrentPasswordException exception, WebRequest request) {
        log.error("IncorrectCurrentPasswordException handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        setCommonData(exception,errorResponse,request);
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}