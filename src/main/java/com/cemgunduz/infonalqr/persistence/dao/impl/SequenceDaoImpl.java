package com.cemgunduz.infonalqr.persistence.dao.impl;

import com.cemgunduz.infonalqr.persistence.dao.SequenceDao;
import com.cemgunduz.infonalqr.persistence.dao.constants.Sequence;
import com.cemgunduz.util.persistence.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by cgunduz on 3/14/14.
 */
@Repository
public class SequenceDaoImpl implements SequenceDao{

    @Autowired
    RedisUtils redisUtils;

    @Override
    public long nextSequence(Sequence sequence) {

        return redisUtils.getRedisTemplate().incr(sequence.getRedisKey());
    }
}
