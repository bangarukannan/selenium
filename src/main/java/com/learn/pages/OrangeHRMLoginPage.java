package com.learn.pages;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends BasePage{

    private final By username = By.id("txtUsername");
    private final By password = By.xpath("//input[@name='txtPassword' and @type='password']");
    private final By loginButton = By.cssSelector("input#btnLogin");

    public OrangeHRMLoginPage sendUserName(String user){
//        DriverManager.getDriver().findElement(username).sendKeys(user);
        sendKeys(username, user, WaitStrategy.PRESENSE);
        return this;
    }

    public OrangeHRMLoginPage sendPassword(String pwd){
//        DriverManager.getDriver().findElement(password).sendKeys(pwd);
        sendKeys(password, pwd, WaitStrategy.PRESENSE);
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
//        DriverManager.getDriver().findElement(loginButton).click();
        click(loginButton, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }

    public String getPageTitle(){
        return getCurrentPageTitle();
//        return DriverManager.getDriver().getTitle();
    }
}
