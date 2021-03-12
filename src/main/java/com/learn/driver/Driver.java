package com.learn.driver;

import com.learn.constants.FrameworkConstants;
import com.learn.utils.ReadPropertyFile;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {

    private Driver(){

    }

    public static void initDriver(){
        if(Objects.isNull(DriverManager.getDriver())){
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedirverpath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(ReadPropertyFile.getPropertyValue("url"));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
