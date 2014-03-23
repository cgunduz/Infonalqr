package com.cemgunduz.infonalqr.persistence.entity;

import com.cemgunduz.util.persistence.annotation.AutoIncrement;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by cgunduz on 3/20/14.
 */

@Document(collection = "User")
public class User {

    @Id
    @AutoIncrement
    private Long id;

    private String name;
    private String lastname;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
