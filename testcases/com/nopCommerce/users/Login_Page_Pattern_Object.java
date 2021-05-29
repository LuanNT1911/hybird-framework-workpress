package com.nopCommerce.users;

import User.UserDataTest;
import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

@Feature("User")
public class Login_Page_Pattern_Object extends BaseTest {

    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    CustomerInforPageObject customerInforPage;
    UserDataTest userData;
    //    PageGeneratorManager pageGenerator;

    String firstName = "Earn";
    String lastName = "Shawn";
    String email = "earnshaw@gmail.com";
    String password = "123456";
    String gender = "Male";
    String postFixEmail = getRandomNumber() + "@gmail.com";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        userData = UserDataTest.getFile(GlobalConstants.PROJECT_LOCATION + "\\testdata\\User\\UserData.json");
        firstName = userData.getFirstname();
        lastName = userData.getLastname();
        email = userData.getEmail() + postFixEmail;
        password = userData.getPassword();
        gender = userData.getGender();
    }

    @Description("TC01: Register to System")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register_To_System() {
        log.info("Register - Step 01: Opening Register page");
        registerPage = (RegisterPageObject) homePage.openDynamicPage(
                driver, "header", "Register");

        registerPage.sleepInSeconds(1);

        log.info("Register - Step 01: Select to Gender checkbox: " + gender);
        registerPage.clickRadioButtonById(driver, "gender-male");

        log.info("Register - Step 02: Input to First Name textbox: " + firstName);
        registerPage.inputToTextboxById(driver, "FirstName", firstName);

        log.info("Register - Step 03: Input to Last Name textbox: " + lastName);
        registerPage.inputToTextboxById(driver, "LastName", lastName);

        log.info("Register - Step 04: Input to Email textbox: " + email);
        registerPage.inputToTextboxById(driver, "Email", email);

        log.info("Register - Step 05: Input to Password textbox: " + password);
        registerPage.inputToTextboxById(driver, "Password", password);

        log.info("Register - Step 06: Input to Confirm Password textbox: " + password);
        registerPage.inputToTextboxById(driver, "ConfirmPassword", password);

        log.info("Register - Step 07: Click to Register button");
        registerPage.clickToButtonByValue(driver, "Register");

        log.info("Register - Step 08: Verify success message is displayed");
        verifyTrue(registerPage.isSuccessMessageDisplayed());

        log.info("Register - Step 09: Click to Log Out link");
        homePage = (HomePageObject) registerPage.openDynamicPage(
                driver, "header", "Log out");
    }

    @Description("TC02: Login to System")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_02_Login_To_System() {

        log.info("Login - Step 01: Click to Log in link");
        loginPage = (LoginPageObject) homePage.openDynamicPage(
                driver, "header", "Log in");

        log.info("Login - Step 01: Input to Email textbox: " + email);
        loginPage.sleepInSeconds(1);
//        loginPage.isBeingLoginPage();
        loginPage.inputToTextboxById(driver, "Email", email);

        log.info("Login - Step 02: Input to Password textbox: " + password);
        loginPage.inputToTextboxById(driver, "Password", password);

        log.info("Login - Step 03: Click to Log in button");
        loginPage.clickToButtonByValue(driver, "Log in");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Login - Step 04: Verify My account link is displayed");
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Description("TC03: Check Customer Info")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_03_Customer_Info() {
        log.info("Customer - Step 01: Click to My account link");
        customerInforPage = (CustomerInforPageObject) homePage.openDynamicPage(
                driver, "header", "My account");

        log.info("Customer - Step 02: Verify Gender checkbox is checked: " + gender);
        verifyTrue(customerInforPage.isRadioButtonCheckedById(driver, "gender-male"));

        log.info("Customer - Step 03: Verify Fist Name textbox is: " + firstName);
        verifyEquals(customerInforPage.getTextFromTextboxById(driver, "FirstName"), firstName);

        log.info("Customer - Step 04: Verify Last Name textbox is:" + lastName);
        verifyEquals(customerInforPage.getTextFromTextboxById(driver, "LastName"), lastName);

        log.info("Customer - Step 05: Verify Email textbox is:" + email);
        verifyEquals(customerInforPage.getTextFromTextboxById(driver, "Email"), email);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
