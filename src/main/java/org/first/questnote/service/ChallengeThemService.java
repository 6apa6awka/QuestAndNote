package org.first.questnote.service;

import org.first.questnote.dao.entity.UserEntity;
import org.first.questnote.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * Created by eorlov on 17.07.2015.
 * Service for login controller to work with repository
 */

@Service
public class ChallengeThemService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getNewUser(String ip){
        UserEntity userEntity = new UserEntity.UserBuilder()
                .setPassword("111111").setRegistrationDate(new Date()).setIp(ip)
                .build();
        userEntity = userRepository.save(userEntity);
        return  userEntity;
    }

    public UserEntity getUserById(String id){
        return  userRepository.findOne(id);
    }

    public UserEntity saveUser(UserEntity userEntity){
        return  userRepository.save(userEntity);
    }
}
