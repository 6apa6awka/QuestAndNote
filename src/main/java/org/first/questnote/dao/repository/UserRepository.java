package org.first.questnote.dao.repository;

import org.first.questnote.dao.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eorlov on 17.07.2015.
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
