package com.cemgunduz.infonalqr.unit;

import com.cemgunduz.infonalqr.persistence.dao.UserMongoDao;
import com.cemgunduz.infonalqr.persistence.entity.User;
import com.cemgunduz.infonalqr.services.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by cgunduz on 3/20/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/applicationContext.xml"})
public class UserServices {

    @Autowired
    UserService userService;

    @Autowired
    @SuppressWarnings("all")
    UserMongoDao userMongoDao;


    @Test
    public void userServiceExampleUnitTest()
    {
        long totalCount = userMongoDao.count();

        User testUser = new User();
        testUser.setLastname(randomStringGen());
        testUser.setName(randomStringGen());
        testUser.setPhoneNumber(randomPhoneNumberGen());
        userService.addUser(testUser);

        assert (totalCount + 1) == userMongoDao.count();
    }

    @Test
    public void userServiceExampleUnitTestWithIntegrityCheck()
    {
        User testUser = new User();
        testUser.setLastname("TestLastName");
        testUser.setName("TestName");
        testUser.setPhoneNumber("5395970000");
        userService.addUser(testUser);

        User detachedTestUser = userMongoDao.findOne(testUser.getId());

        assert detachedTestUser.getName().equals(testUser.getName());
        assert detachedTestUser.getLastname().equals(testUser.getLastname());
        assert detachedTestUser.getPhoneNumber().equals(testUser.getPhoneNumber());

        userService.deleteUser(testUser.getId());
    }

    private String randomStringGen()
    {
        int length = new Random().nextInt(7)+3;
        return RandomStringUtils.randomAlphabetic(length).toUpperCase();
    }

    private String randomPhoneNumberGen()
    {
        return RandomStringUtils.randomNumeric(10);
    }
}
