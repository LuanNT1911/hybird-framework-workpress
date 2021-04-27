package com.orangehrm.employee;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.*;

public class Employee_01_Add_Edit_Employee_User extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    EmployeeDetailPageObject employeeDetailPage;
    UserDetailPageObject userDetailPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        log.info("Pre-Condition - Step 01: Enter to Username textbox");
        loginPage.enterToUsernameTextbox("Admin");

        log.info("Pre-Condition - Step 02: Enter to Password textbox");
        loginPage.enterToPasswordTextbox("admin123");

        log.info("Pre-Condition - Step 01: Click to Login button");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_Employee() {

    }

    @Test
    public void Employee_02_Search_Employee() {

    }

    @Test
    public void Employee_03_Edit_Employee_By_Personal() {

    }

    @Test
    public void Employee_04_Edit_Employee_By_Contact() {

    }

    @Test
    public void Employee_05_Edit_Employee_By_Job() {

    }

    @Test
    public void Employee_06_Edit_Employee_By_Salary() {

    }

    @Test
    public void Employee_07_Add_User_To_Employee() {

    }

    @Test
    public void Employee_08_Search_User() {

    }

    @Test
    public void Employee_09_Delete_User() {

    }

    @Test
    public void Employee_09_Delete_Employee() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
