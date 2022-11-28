//package com.epam.team1.emotional.help.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.persistence.EntityNotFoundException;
//
//@RestControllerAdvice
//public class RestExceptionHandler {
//
//    @ExceptionHandler({EntityNotFoundException.class})
//    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException exception) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setMessage(exception.getMessage());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//}