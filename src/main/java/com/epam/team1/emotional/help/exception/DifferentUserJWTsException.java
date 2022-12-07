package com.epam.team1.emotional.help.exception;

public class DifferentUserJWTsException extends RuntimeException {

    public DifferentUserJWTsException(String message) {
        super(message);
    }

    public DifferentUserJWTsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DifferentUserJWTsException(Throwable cause) {
        super(cause);
    }

    public DifferentUserJWTsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
