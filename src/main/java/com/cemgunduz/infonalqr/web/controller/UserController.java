package com.cemgunduz.infonalqr.web.controller;

import com.cemgunduz.infonalqr.persistence.entity.User;
import com.cemgunduz.infonalqr.services.UserService;
import com.cemgunduz.infonalqr.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import java.util.List;

/**
 * Created by cgunduz on 3/20/14.
 */

@Controller
@Scope("view")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserModels userModels;

    public List<User> findAll()
    {
        return userService.findAll();
    }

    public void addNewUser()
    {
        userService.addUser(userModels.getNewUser());
    }

    public void updateUser()
    {
        userService.updateUser(userModels.getSelectedUser());
    }

    public void deleteUser()
    {
        userService.deleteUser(userModels.getSelectedUser().getId());
    }

    public UserModels getUserModels()
    {
        return userModels;
    }
}
