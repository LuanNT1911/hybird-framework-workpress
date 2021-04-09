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
        registerPage.sleepInSeconds(2);
        registerPage.inputToFirstNameTextbox("Earn");
        registerPage.inputToLastNameTextbox("Shaw");
        registerPage.inputToEmailTextbox("earnshaw@gmail.com");
        registerPage.inputToPasswordTextbox("123456");
        registerPage.inputToConfirmPasswordTextbox("123456");
        registerPage.clickToRegisterButton();

        Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

        homePage = registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login_To_System() {
//        homePage.clickToResgisterLink();
        loginPage = homePage.clickToLoginLink();
//		loginPage.sleepInSeconds(2);
//        loginPage.isBeingLoginPage();
        loginPage.inputToEmailTextbox("earnshaw@gmail.com");
        loginPage.inputToPasswordTextbox("123456");

        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_Customer_Info() {
        customerInforPage = homePage.clickToMyAccountLink();
        Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), "Earn");
        Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), "Shaw");
        Assert.assertEquals(customerInforPage.getEmailTextboxValue(), "earnshaw@gmail.com");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
