package org.first.questnote.rest.response;

import org.first.questnote.dao.entity.UserEntity;
import org.first.questnote.rest.AnswerCode;

/**
 * Created by eorlov on 04.08.2015.
 */

public class Response {

    private AnswerCode answerCode;
    private String message;
    private UserEntity userEntity;

    public Response() {
    }

    public Response(AnswerCode answerCode) {
        this.answerCode = answerCode;
        this.message = answerCode.getMessage();
    }

    public AnswerCode getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(AnswerCode answerCode) {
        this.answerCode = answerCode;
        this.message = answerCode.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
