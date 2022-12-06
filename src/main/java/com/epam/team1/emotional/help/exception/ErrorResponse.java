package com.epam.team1.emotional.help.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

    public ErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ErrorResponse(int status, String message, long timeStamp,String exception, String details) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.exception = exception;
        this.details = details;
    }

    private int status;
    private String message;
    private long timeStamp;

    private String exception;

    private String details;


}
