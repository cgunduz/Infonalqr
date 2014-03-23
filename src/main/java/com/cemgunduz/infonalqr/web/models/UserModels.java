package com.cemgunduz.infonalqr.web.models;

import com.cemgunduz.infonalqr.persistence.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by cgunduz on 3/22/14.
 */

@Component
@Scope("view")
public class UserModels {

    private User newUser;
    private User selectedUser;

    public UserModels()
    {
        newUser = new User();
        selectedUser = new User();
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
