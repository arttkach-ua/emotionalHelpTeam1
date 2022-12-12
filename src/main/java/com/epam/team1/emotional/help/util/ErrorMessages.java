package com.epam.team1.emotional.help.util;

/**
 * Class is used to store error messages
 * @author Tkach Artem
 */
public final class ErrorMessages {
    private ErrorMessages(){}
    public static final String RESULT_NOT_FOUND = "result not found";
    public static final String QUESTIONNAIRE_NOT_FOUND = "Questionnaire with id %d not found";
    public static final String ARTICLE_NOT_FOUND = "Article with id %d not found";
    public static final String USER_BY_ID_NOT_FOUND = "User with id %d not found";
    public static final String USER_BY_EMAIL_NOT_FOUND = "User with e-mail %s not found";
    public static final String ERROR_WHILE_EMAIL_SENDING = "Error while e-mail sending. {}";
}
