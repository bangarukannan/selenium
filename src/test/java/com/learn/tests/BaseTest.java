package com.learn.tests;

import com.learn.driver.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected BaseTest(){

    }

    @BeforeMethod
    public void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
