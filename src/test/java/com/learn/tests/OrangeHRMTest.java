package com.learn.tests;

import com.learn.driver.DriverManager;
import com.learn.pages.OrangeHRMHomePage;
import com.learn.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{

    @Test(dataProvider = "loginDataProvider")
    public void LoginLogoutTest(String username, String password) throws Exception{
        String actualTitle = new OrangeHRMLoginPage().sendUserName(username).sendPassword(password)
                .clickLogin().clickWelcome().clickLogout().getPageTitle();
        Assertions.assertThat(actualTitle).as("LOGIN PAGE TITLE DIFFERS").isEqualTo("OrangeHRM");
    }

//    parallel keyword is by default by false. If it is true, then it will execute as per the object size
// To set the data-provider-thread-count with specific number,  data-provider-thread-count="3" needs to add in testng.xml
    @DataProvider(name = "loginDataProvider",  parallel = true)
    public Object[][] getLoginData(){
        return new Object[][]{
                {"Admin","admin123"},
                {"admin","admin123"},
                {"Admin","admin13"}
        };
    }
}
