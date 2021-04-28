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
    EmployeeListPageObject employeeListPage;
    UserDetailPageObject userDetailPage;

    String firstName, lastName, employeeID;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        firstName = "Now " + getRandomNumber();
        lastName = "Beamin " + getRandomNumber();

        log.info("Pre-Condition - Step 01: Enter to Username textbox");
        loginPage.enterToUsernameTextbox("Admin");

        log.info("Pre-Condition - Step 02: Enter to Password textbox");
        loginPage.enterToPasswordTextbox("admin123");

        log.info("Pre-Condition - Step 01: Click to Login button");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_Employee() {
        log.info("Add Employee - Step 01: Navigate to Employee List");
        dashboardPage.openDynamicMenuPage(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

        employeeListPage.sleepInSeconds(1);
        log.info("Add Employee - Step 02: Click to Add button");
        employeeDetailPage = employeeListPage.clickToAddButton();

        log.info("Add Employee - Step 03: Enter to FirstName textbox: " + firstName);
        employeeDetailPage.enterToFirstNameTextbox(firstName);

        log.info("Add Employee - Step 04: Enter to LastName textbox: " + lastName);
        employeeDetailPage.enterToLastNameTextbox(lastName);

        employeeID = employeeDetailPage.getEmployeeIdAtAddForm();

        log.info("Add Employee - Step 05: Enter to Save button");
        employeeDetailPage.clickToSaveButton();

        log.info("Add Employee - Step 06: Verify FullName header is displayed: " + firstName + " " + lastName);
        verifyTrue(employeeDetailPage.isFullNameDisplayedAtHeader(firstName + " " + lastName));

        log.info("Add Employee - Step 07: Verify FirstName is displayed: " + firstName);
        verifyEquals(employeeDetailPage.getFirstNameDisplayedAtPersonalForm(), firstName);

        log.info("Add Employee - Step 08: Verify LastName is displayed: " + lastName);
        verifyEquals(employeeDetailPage.getLastNameDisplayedAtPersonalForm(), lastName);

        log.info("Add Employee - Step 09: Verify Employee ID is displayed: " + employeeID);
        verifyEquals(employeeDetailPage.getEmployeeIDAtPersonalForm(), employeeID);

    }


    @Test
    public void Employee_02_Edit_Employee_By_Personal() {
        log.info("Edit Employee [Personal] - Step 01: Click to Edit button at Personal Details form");

        log.info("Edit Employee [Personal] - Step 02: Enter new info to 'Firstname' textbox");

        log.info("Edit Employee [Personal] - Step 03: Enter new infor to 'Lastname' textbox");

        log.info("Edit Employee [Personal] - Step 04: Enter new infor to 'SSN Number' textbox");

        log.info("Edit Employee [Personal] - Step 05: Click to 'Gender' radio with: ");

        log.info("Edit Employee [Personal] - Step 06: Select to 'Marital Status' dropdown with: ");

        log.info("Edit Employee [Personal] - Step 07: Select to 'Nationality' dropdown with" );

        log.info("Edit Employee [Personal] - Step 08: Enter new info to 'Date of Birth' textbox" );

        log.info("Edit Employee [Personal] - Step 09: Click to 'Save' button at 'Personal Details' form" );
    }

    @Test
    public void Employee_03_Edit_Employee_By_Contact() {

    }

    @Test
    public void Employee_04_Edit_Employee_By_Job() {

    }

    @Test
    public void Employee_05_Edit_Employee_By_Salary() {

    }

    @Test
    public void Employee_06_Add_User_To_Employee() {

    }

    @Test
    public void Employee_07_Search_User() {

    }

    @Test
    public void Employee_09_Delete_User() {

    }

    @Test
    public void Employee_02_Search_Employee() {
    }

    @Test
    public void Employee_10_Delete_Employee() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
