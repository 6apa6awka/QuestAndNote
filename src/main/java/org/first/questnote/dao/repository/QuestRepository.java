package org.first.questnote.dao.repository;

import org.first.questnote.dao.entity.QuestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by eorlov on 17.07.2015.
 */
public interface QuestRepository extends MongoRepository<QuestEntity, String> {
    List<QuestEntity> findByOwnerLike(String owner);
}
