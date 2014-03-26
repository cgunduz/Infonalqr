package com.cemgunduz.infonalqr.functionality;

import com.cemgunduz.infonalqr.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by cgunduz on 3/26/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/applicationContext.xml"})
public class UserPage {

    @Autowired
    UserService userService;

    private static final String SITE_PATH = "localhost:8080";

    /**
     * Adds and deletes a user
     */
    @Test
    public void exampleFunctionalityTest()
    {
        WebDriver firefoxDriver = new FirefoxDriver();

        firefoxDriver.get(SITE_PATH);

        WebElement webElement = firefoxDriver.findElement(By.id("titleLarge"));
        assert webElement.getText().equals("Sample User Managment Page For N11");

        int count = userService.findAll().size();

        firefoxDriver.findElement(By.id("addUserButton")).click();

        firefoxDriver.findElement(By.id("new_name")).sendKeys("CemTest");
        firefoxDriver.findElement(By.id("new_lastname")).sendKeys("GunduzTest");

        firefoxDriver.findElement(By.id("saveNewButton")).click();

        assert count + 1 == userService.findAll().size();

        // TODO : Has to be more specific as the page evolves
        List<WebElement> trList = firefoxDriver.findElements(By.tagName("td"));
        for(WebElement element : trList)
            if(element.getText().equals("CemTest"))
            {
                element.click();
                break;
            }

        firefoxDriver.findElement(By.id("Delete")).click();
        firefoxDriver.findElement(By.id("confirm")).click();
    }


}
