package com.learn.tests;


import com.learn.driver.Driver;
import com.learn.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public final class LoginPageTest extends BaseTest{

    private LoginPageTest(){

    }
    @Test
    public void loginTest1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation Testing", Keys.ENTER);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(100, TimeUnit.MILLISECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().getCurrentUrl();

    }

}
