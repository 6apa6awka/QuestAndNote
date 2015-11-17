package org.first.questnote.service;

import org.first.questnote.dao.entity.QuestEntity;
import org.first.questnote.dao.entity.UserEntity;
import org.first.questnote.dao.repository.QuestRepository;
import org.first.questnote.dao.repository.UserRepository;
import org.first.questnote.rest.AnswerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by eorlov on 17.07.2015.
 * Service for login controller to work with repository
 */

@Service
public class ChallengeThemService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestRepository questRepository;

    public UserEntity getNewUser(String ip){
        UserEntity userEntity = new UserEntity.UserBuilder()
                .setPassword("111111").setRegistrationDate(new Date()).setIp(ip)
                .build();
        userEntity = userRepository.save(userEntity);
        return  userEntity;
    }

    public AnswerCode login(Map<String, String> data){
        String id = data.get("id");
        String password = data.get("password");
        UserEntity user = userRepository.findOne(id);
        if(user==null){
            return AnswerCode.INCORRECT_USER;
        }
        if(!password.equals(user.getPassword())){
            return AnswerCode.INCORRECT_PASSWORD;
        }
        return AnswerCode.LOGGING_OK;
    }

    public UserEntity getUserById(String id){
        return  userRepository.findOne(id);
    }

    public UserEntity saveUser(UserEntity userEntity){
        return  userRepository.save(userEntity);
    }

    public QuestEntity saveQuest(QuestEntity questEntity){
        return  questRepository.save(questEntity);
    }

    public List<QuestEntity> getQuestsByOwner(String owner){
        return  questRepository.findByOwnerLike(owner);
    }
}
