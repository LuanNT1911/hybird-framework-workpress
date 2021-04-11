package com.nopCommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

public class Level_6_Login_Page_Generator_Manager extends BaseTest {

    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    CustomerInforPageObject customerInforPage;
    //    PageGeneratorManager pageGenerator;
    String firstName = "Earn";
    String lastName = "Shawn";
    String email = "earnshaw@gmail.com";
    String password = "123456";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
//        pageGenerator = PageGeneratorManager.getPageGenerator();
        homePage = PageGeneratorManager.getHomePage(driver);

    }

    @Test
    public void User_01_Register_To_System() {
        registerPage = homePage.clickToResgisterLink();
        registerPage.sleepInSeconds(1);
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(email);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

        homePage = registerPage.clickToLogoutLink(driver);
    }

    @Test
    public void User_02_Login_To_System() {
//        homePage.clickToResgisterLink();
        loginPage = homePage.clickToLoginLink(driver);
        loginPage.sleepInSeconds(1);
//        loginPage.isBeingLoginPage();
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);

        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_Customer_Info() {
        customerInforPage = homePage.clickToMyAccountLink();
        Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
