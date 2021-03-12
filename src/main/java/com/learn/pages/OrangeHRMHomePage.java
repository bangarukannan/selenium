package com.learn.pages;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import com.learn.reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePage extends BasePage{

    private final By btnWelcome = By.id("welcome");
    private final By lnkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() throws Exception{
//        DriverManager.getDriver().findElement(btnWelcome).click();
        click(btnWelcome, WaitStrategy.CLICKABLE);
//        ExtentReportManager.
        return this;
    }

    public OrangeHRMLoginPage clickLogout(){
//        new WebDriverWait(DriverManager.getDriver(),10)
//                .until(ExpectedConditions.elementToBeClickable(lnkLogout));
//        new WebDriverWait(DriverManager.getDriver(),10)
//                .until(d -> d.findElement(lnkLogout).isDisplayed());  //This is using JAVA 8 Function
//        DriverManager.getDriver().findElement(lnkLogout).click();
        click(lnkLogout, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();
    }
}
