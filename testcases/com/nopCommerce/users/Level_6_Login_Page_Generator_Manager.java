package com.nopCommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
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
        log.info("Register - Step 01: Opening Register page");
        registerPage = (RegisterPageObject) homePage.openDynamicPage(
                driver, "header", "Register");

        log.info("Register - Step 02: Input to First Name textbox: " + firstName);
//        registerPage.sleepInSeconds(1);
        registerPage.inputToFirstNameTextbox(firstName);

        log.info("Register - Step 03: Input to Last Name textbox: " + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        log.info("Register - Step 04: Input to Email textbox: " + email);
        registerPage.inputToEmailTextbox(email);

        log.info("Register - Step 05: Input to Password textbox: " + password);
        registerPage.inputToPasswordTextbox(password);

        log.info("Register - Step 06: Input to Confirm Password textbox: " + password);
        registerPage.inputToConfirmPasswordTextbox(password);

        log.info("Register - Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Step 08: Verify success message is displayed");
        verifyTrue(registerPage.isSuccessMessageDisplayed());

        log.info("Register - Step 09: Click to Log Out link");
        homePage = (HomePageObject) registerPage.openDynamicPage(
                driver, "header", "Log out");
    }

    @Test
    public void User_02_Login_To_System() {
//        homePage.clickToResgisterLink();
        log.info("Login - Step 01: Click to Log in link");
        loginPage = (LoginPageObject) homePage.openDynamicPage(
                driver, "header", "Log in");

        log.info("Login - Step 01: Input to Email textbox: " + email);
        loginPage.sleepInSeconds(1);
//        loginPage.isBeingLoginPage();
        loginPage.inputToEmailTextbox(email);

        log.info("Login - Step 02: Input to Password textbox: " + password);
        loginPage.inputToPasswordTextbox(password);

        log.info("Login - Step 03: Click to Log in button");
        homePage = loginPage.clickToLoginButton();

        log.info("Login - Step 04: Verify My account link is displayed");
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_Customer_Info() {
        log.info("Customer - Step 01: Click to My account link");
        customerInforPage = (CustomerInforPageObject) homePage.openDynamicPage(
                driver, "header", "My account");

        log.info("Customer - Step 02: Verify Fist Name textbox is: " + firstName);
        verifyEquals(customerInforPage.getFirstNameTextboxValue(), firstName);

        log.info("Customer - Step 03: Verify Last Name textbox is:" + lastName);
        verifyEquals(customerInforPage.getLastNameTextboxValue(), lastName);

        log.info("Customer - Step 04: Verify Email textbox is:" + email);
        verifyEquals(customerInforPage.getEmailTextboxValue(), email);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
