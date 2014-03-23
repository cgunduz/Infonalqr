package com.cemgunduz.infonalqr.services;

import com.cemgunduz.infonalqr.persistence.entity.User;

import java.util.List;

/**
 * Created by cgunduz on 3/20/14.
 */
public interface UserService {

    public void addUser(User transientUser);
    public void updateUser(User transientUser);
    public void deleteUser(Long userId);
    public List<User> findAll();
}
