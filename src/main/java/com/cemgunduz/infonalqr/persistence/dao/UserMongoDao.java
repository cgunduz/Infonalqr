package com.cemgunduz.infonalqr.persistence.dao;

import com.cemgunduz.infonalqr.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cgunduz on 3/20/14.
 */
public interface UserMongoDao extends MongoRepository<User,Long> {

}
