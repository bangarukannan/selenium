package com.learn.pages;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import com.learn.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
* This class contains all common methods used in all Page classes
* */
public class BasePage {

    protected void sendKeys(By by, String value, WaitStrategy wait){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, wait);
        webElement.sendKeys(value);
    }

    protected void click(By by, WaitStrategy wait){
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(by, wait);
        webElement.click();
    }

    protected String getCurrentPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    private void wait(By by, String waitStrategy){
        if(waitStrategy.equalsIgnoreCase("clickable"))
            new WebDriverWait(DriverManager.getDriver(),10)
                    .until(ExpectedConditions.elementToBeClickable(by));
        else if(waitStrategy.equalsIgnoreCase("toPresent"))
            new WebDriverWait(DriverManager.getDriver(),10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
