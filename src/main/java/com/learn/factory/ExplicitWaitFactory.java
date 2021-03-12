package com.learn.factory;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
* Factory package is to have the reusable methods across the framework
* */
public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(By by, WaitStrategy wait){
        WebElement webElement = null;
        if(wait == WaitStrategy.CLICKABLE)
            webElement = new WebDriverWait(DriverManager.getDriver(),10)
                    .until(ExpectedConditions.elementToBeClickable(by));
        else if(wait == WaitStrategy.PRESENSE)
            webElement = new WebDriverWait(DriverManager.getDriver(),10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        else if(wait == WaitStrategy.NONE)
            webElement = DriverManager.getDriver().findElement(by);
        return webElement;
    }
}
