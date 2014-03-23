package com.cemgunduz.infonalqr.persistence.dao.constants;

/**
 * Created by cgunduz on 3/14/14.
 */
public enum Sequence {

    User("user_seq");

    private String redisKey;

    private Sequence(String redisKey)
    {
        this.redisKey = redisKey;
    }

    public String getRedisKey()
    {
        return redisKey;
    }
}
