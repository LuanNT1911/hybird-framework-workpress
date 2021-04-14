package com.wordpress.posts;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageGeneratorManager;

public class Level_11_Login_Undisplayed extends BaseTest {

    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void Login_01_Valid_Email_Password() {
        loginPage.inputToUsernameTextbox("automationeditor");
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox("automationfc");
        loginPage.clickToLoginButton();

        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        verifyTrue(dashboardPage.isDashboardHeaderTextDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
