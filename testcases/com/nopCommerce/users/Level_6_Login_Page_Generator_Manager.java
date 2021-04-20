package com.nopCommerce.users;

import com.nopCommerce.commons.Commons_01_Register_ToSystem;
import commons.BaseTest;
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
public class Level_6_Login_Page_Generator_Manager extends BaseTest {

    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    CustomerInforPageObject customerInforPage;
    //    PageGeneratorManager pageGenerator;

    String firstName = "Earn";
    String lastName = "Shawn";
    String email = Commons_01_Register_ToSystem.email;
    String password = Commons_01_Register_ToSystem.password;
    String gender = "Male";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);

    }

//    @Description("TC01: Register to System")
//    @Severity(SeverityLevel.NORMAL)
//    @Test
//    public void User_01_Register_To_System() {

//        log.info("Register - Step 09: Click to Log Out link");
//        homePage = (HomePageObject) registerPage.openDynamicPage(
//                driver, "header", "Log out");
//    }

    @Description("TC02: Login to System")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_02_Login_To_System() {
        email = Commons_01_Register_ToSystem.email;
        password = Commons_01_Register_ToSystem.password;

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

    @Description("TC03: Check Customer Info")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_03_Customer_Info() {
        log.info("Customer - Step 01: Click to My account link");
        customerInforPage = (CustomerInforPageObject) homePage.openDynamicPage(
                driver, "header", "My account");

        log.info("Customer - Step 02: Verify Gender checkbox is checked: " + gender);
        verifyTrue(customerInforPage.isGenderCheckboxChecked(gender));

        log.info("Customer - Step 03: Verify Fist Name textbox is: " + firstName);
        verifyEquals(customerInforPage.getFirstNameTextboxValue(), firstName);

        log.info("Customer - Step 04: Verify Last Name textbox is:" + lastName);
        verifyEquals(customerInforPage.getLastNameTextboxValue(), lastName);

        log.info("Customer - Step 05: Verify Email textbox is:" + email);
        verifyEquals(customerInforPage.getEmailTextboxValue(), email);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
