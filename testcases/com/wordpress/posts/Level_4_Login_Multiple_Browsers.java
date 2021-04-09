package com.wordpress.posts;

import commons.BaseTest;
import commons.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_4_Login_Multiple_Browsers extends BaseTest {

    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;

    @Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Parameters("url")
    @BeforeMethod
    public void beforeMethod(String url) {
        driver.get(url);
        loginPage = new LoginPageObject(driver);
    }

    @Test
    public void Login_01_Empty_Email_Username() {
//        loginPage.inputToUsernameTextbox("");
        loginPage.clickToContinueButton();

        Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
                "Please enter a username or email address.");
    }

    @Test
    public void Login_02_Invalid_Email_Username() {
        loginPage.inputToUsernameTextbox("auto@@");
        loginPage.clickToContinueButton();

        Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
                "User does not exist. Would you like to create a new account?");
    }

    //	@Test
    public void Login_03_Email_Username_Not_Exist() {
        loginPage.inputToUsernameTextbox("auto@auto.com");
        loginPage.clickToContinueButton();

        Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
                "User does not exist. Would you like to create a new account?");
    }

    //	@Test
    public void Login_04_Empty_Password() {
        loginPage.inputToUsernameTextbox("automationeditor");
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox("");
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
                "Don't forget to enter your password.");
    }

    //	@Test
    public void Login_05_Invalid_Password() {
        loginPage.inputToUsernameTextbox("automationeditor");
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox("1asd");
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
                "Oops, that's not the right password. Please try again!");
    }

    //	@Test
    public void Login_06_Incorrect_Password() {
        loginPage.inputToUsernameTextbox("automationeditor");
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox("1asd");
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
                "Oops, that's not the right password. Please try again!");
    }

    //	@Test
    public void Login_07_Valid_Email_Password() {
        loginPage.inputToUsernameTextbox("automationeditor");
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox("automationfc");
        loginPage.clickToLoginButton();

        dashboardPage = new DashboardPageObject(driver);
        Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
