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
    String editFirstName, editLastName, editSSN, editGender, editDOB, editMaritalStatus, editNationality;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        firstName = "Now " + getRandomNumber();
        lastName = "Beamin " + getRandomNumber();

        editFirstName = "Futute" + getRandomNumber();
        editLastName = "Grab" + getRandomNumber();
        editSSN = "329-68-2055";
        editGender = "Male";
        editDOB = "1994-11-19";
        editMaritalStatus = "Single";
        editNationality = "Vietnamese";

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
        employeeDetailPage.enterToFirstNameTextboxAtAddEmployeeForm(firstName);

        log.info("Add Employee - Step 04: Enter to LastName textbox: " + lastName);
        employeeDetailPage.enterToLastNameTextboxAddEmployeeForm(lastName);

        employeeID = employeeDetailPage.getEmployeeIdAtAddEmployeeForm();

        log.info("Add Employee - Step 05: Enter to Save button");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Employee", "Save");

        log.info("Add Employee - Step 06: Verify FullName header is displayed: " + firstName + " " + lastName);
        verifyTrue(employeeDetailPage.isFullNameDisplayedAtHeader(firstName + " " + lastName));

        log.info("Add Employee - Step 07: Verify FirstName is displayed: " + firstName);
        verifyEquals(employeeDetailPage.getFirstNameDisplayedAtPersonalDetailsForm(), firstName);

        log.info("Add Employee - Step 08: Verify LastName is displayed: " + lastName);
        verifyEquals(employeeDetailPage.getLastNameDisplayedAtPersonalDetailsForm(), lastName);

        log.info("Add Employee - Step 09: Verify Employee ID is displayed: " + employeeID);
        verifyEquals(employeeDetailPage.getEmployeeIDAtPersonalDetailsForm(), employeeID);

    }


    @Test
    public void Employee_02_Edit_Employee_By_Personal() {
        log.info("Edit Employee [Personal] - Step 01: Click to Edit button at Personal Details form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Personal Details", "Edit");

        log.info("Edit Employee [Personal] - Step 02: Enter new info to 'Firstname' textbox");
        employeeDetailPage.enterToFirstNameTextboxAtPersonalDetailsForm(editFirstName);

        log.info("Edit Employee [Personal] - Step 03: Enter new infor to 'Lastname' textbox");
        employeeDetailPage.enterToLastNameTextboxAtPersonalDetailsForm(editLastName);

        log.info("Edit Employee [Personal] - Step 04: Enter new infor to 'SSN Number' textbox");
        employeeDetailPage.enterToSSNNumberTextboxAtPersonalDetailsForm(editSSN);

        log.info("Edit Employee [Personal] - Step 05: Click to 'Gender' radio with: ");
        employeeDetailPage.clickToGenderRadioAtPersonalDetailsForm(editGender);

        log.info("Edit Employee [Personal] - Step 06: Select to 'Marital Status' dropdown with: ");
        employeeDetailPage.selectMaritalStatusDropdownAtPersonalDetailsForm(editMaritalStatus);

        log.info("Edit Employee [Personal] - Step 07: Select to 'Nationality' dropdown with");
        employeeDetailPage.selectNationalityDropdownAtPersonalDetailsForm(editNationality);

        log.info("Edit Employee [Personal] - Step 08: Enter new info to 'Date of Birth' textbox");
        employeeDetailPage.enterToDateOfBirhtTextboxAtPersonalDetailsForm(editDOB);

        log.info("Edit Employee [Personal] - Step 09: Click to 'Save' button at 'Personal Details' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Personal Details", "Save");

        log.info("Edit Employee [Personal] - Step 10: Verify Success message displayed with value 'Successfully Saved'");
        verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailsForm(), "Successfully Saved");

        log.info("Edit Employee [Personal] - Step 11: Verify 'Firstname' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getFirstNameDisplayedAtPersonalDetailsForm(), editFirstName);

        log.info("Edit Employee [Personal] - Step 12: Verify 'Lastname' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getLastNameDisplayedAtPersonalDetailsForm(), editLastName);

        log.info("Edit Employee [Personal] - Step 13: Verify 'SSN Number' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getSSNNumberDisplayedAtPersonalDetailsForm(), editSSN);

        log.info("Edit Employee [Personal] - Step 14: Verify 'Gender' radio is edited successfully");
        verifyTrue(employeeDetailPage.isGenderRadioSelect(editGender));

        log.info("Edit Employee [Personal] - Step 15: Verify 'Marital Status' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getSelectItemOfMaritalStatusDropdown(), editMaritalStatus);

        log.info("Edit Employee [Personal] - Step 16: Verify 'Nationality' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getSelectItemOfNationalityDropdown(), editNationality);

        log.info("Edit Employee [Personal] - Step 17: Verify 'Date of Birth' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getDateOfBirhtDisplayedAtPersonalForm(), editDOB);
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

//    @AfterClass(alwaysRun = true)
//    public void afterClass() {
//        closeBrowserAndDriver(driver);
//    }
}
