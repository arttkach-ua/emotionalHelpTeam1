package com.epam.team1.emotional.help.exception;

public class ConformationCodeIsBlankException extends RuntimeException {
    public ConformationCodeIsBlankException(String you_sent_a_blank_message) {
        super(you_sent_a_blank_message);
    }
}
