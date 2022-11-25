package com.epam.team1.emotional.help.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException ex, WebRequest request) {
        return null;
    }
}