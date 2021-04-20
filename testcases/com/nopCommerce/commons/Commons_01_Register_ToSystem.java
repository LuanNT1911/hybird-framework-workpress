package com.nopCommerce.commons;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Commons_01_Register_ToSystem extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    String firstName;
    String lastName;
    public static String email;
    public static String password;
    String gender;

    @Parameters({"browser","url"})
    @BeforeTest
    public void beforeTest(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        firstName = "Earn";
        lastName = "Shawn";
        email = "earnshaw@gmail.com";
        password = "123456";
        gender = "Male";

        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Register - Step 01: Opening Register page");
        registerPage = (RegisterPageObject) homePage.openDynamicPage(
                driver, "header", "Register");

        registerPage.sleepInSeconds(1);

        log.info("Register - Step 01: Select to Gender checkbox: " + gender);
        registerPage.checkToGenderCheckbox(gender);

        log.info("Register - Step 02: Input to First Name textbox: " + firstName);
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

        driver.quit();
    }

}
