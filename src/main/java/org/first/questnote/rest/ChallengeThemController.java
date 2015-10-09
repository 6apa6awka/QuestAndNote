package org.first.questnote.rest;

import org.first.questnote.dao.entity.UserEntity;
import org.first.questnote.rest.response.Response;
import org.first.questnote.service.ChallengeThemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by eorlov on 17.07.2015.
 * Controller for login operation
 */
@RestController
public class ChallengeThemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeThemController.class);

    @Autowired
    private ChallengeThemService challengeThemService;

    @RequestMapping(value = "/getNewUser", produces = MediaType.APPLICATION_JSON_VALUE)
    Response getNewUser(HttpServletRequest httpServletRequest){
        UserEntity user = challengeThemService.getNewUser(httpServletRequest.getRemoteAddr());
        Response response = new Response(AnswerCode.CREATED_NEW_USER);
        response.setUserEntity(user);
        LOGGER.info("new User created {}", user);
        return response;
    }

    @RequestMapping(value = "/getUserById", produces = MediaType.APPLICATION_JSON_VALUE)
    Response getUserById(@RequestParam(required = false) String id){
        UserEntity user = challengeThemService.getUserById(id);
        Response response = new Response(AnswerCode.OK);
        response.setUserEntity(user);
        LOGGER.info("User find {}", user);
        return response;
    }

    @RequestMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
    Response saveUser(@RequestParam(required = false) String id,
                      @RequestParam(required = false) String password,
                      @RequestParam(required = false) String name,
                      @RequestParam(required = false) String secondName,
                      @RequestParam(required = false) String birthDate)
            throws ParseException {

        UserEntity newUserEntity = new UserEntity.UserBuilder()
                .setId(id)
                .setPassword(password)
                .setName(name)
                .setSecondName(secondName)
                .setBirthDate(birthDate)
                .build();
        UserEntity user = challengeThemService.saveUser(newUserEntity);
        Response response = new Response(AnswerCode.CREATED_NEW_USER);
        response.setUserEntity(user);
        LOGGER.info("User saved {}", user);
        return response;
    }
}
