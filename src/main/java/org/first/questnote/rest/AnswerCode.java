package org.first.questnote.rest;

/**
 * Created by eorlov on 04.08.2015.
 */
public enum AnswerCode {
    INCORRECT_PASSWORD("Incorrect password"), LOGGING_OK("You successfully login"),
    CREATED_NEW_USER("New user was created"), OK("Successfully running query");

    private String message;

    AnswerCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
