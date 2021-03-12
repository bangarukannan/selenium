package com.learn.tests;

import com.learn.driver.Driver;
import com.learn.driver.DriverManager;
import org.assertj.core.api.BDDAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {

    private HomePageTest(){

    }
    @Test
    public void homePage(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
//        BDDAssertions.then()
    }
}
