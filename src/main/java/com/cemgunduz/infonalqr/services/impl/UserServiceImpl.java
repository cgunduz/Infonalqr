package com.cemgunduz.infonalqr.services.impl;

import com.cemgunduz.infonalqr.persistence.dao.SequenceDao;
import com.cemgunduz.infonalqr.persistence.dao.UserMongoDao;
import com.cemgunduz.infonalqr.persistence.dao.constants.Sequence;
import com.cemgunduz.infonalqr.persistence.entity.User;
import com.cemgunduz.infonalqr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cgunduz on 3/20/14.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMongoDao userMongoDao;

    @Autowired
    private SequenceDao sequenceDao;

    @Override
    public void addUser(User transientUser) {

        transientUser.setId(sequenceDao.nextSequence(Sequence.User));
        userMongoDao.save(transientUser);
    }

    @Override
    public void updateUser(User transientUser) {

        if(!hasValidUserId(transientUser))
            throw new IllegalArgumentException("Call add for entity calls without valid id");

        userMongoDao.save(transientUser);
    }

    @Override
    public void deleteUser(Long userId) {

        userMongoDao.delete(userId);
    }

    @Override
    public List<User> findAll() {

        return userMongoDao.findAll();
    }

    private boolean hasValidUserId(User user)
    {
        if(user != null && user.getId() != null && user.getId() >= 0)
            return true;

        return false;
    }
}
