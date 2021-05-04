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
    String payGrade, salaryComponent, payFrequency, currency, amount, comments;
    String jobTitle, employeeStatus, jobCategory, joinedDate, subUnit, location, startDate, endDate;

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
        payGrade = "Grade 1";
        salaryComponent = "Manual 1911";
        payFrequency = "Hourly";
        currency = "United States Dollar";
        amount = "55000";
        comments = "Testing";

        jobTitle = "QA Engineer";
        employeeStatus = "Full-Time Contract";
        jobCategory = "Technicians";
        joinedDate = "2020-09-07";
        subUnit = "  Quality Assurance";
        location = "New York Sales Office";
        startDate = "2020-11-07";
        endDate = "2021-11-07";

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

        log.info("Edit Employee [Personal] - Step 02: Enter new info to 'Firstname' textbox with value: " + editFirstName);
        employeeDetailPage.enterToFirstNameTextboxAtPersonalDetailsForm(editFirstName);

        log.info("Edit Employee [Personal] - Step 03: Enter new infor to 'Lastname' textbox with value: " + editLastName);
        employeeDetailPage.enterToLastNameTextboxAtPersonalDetailsForm(editLastName);

        log.info("Edit Employee [Personal] - Step 04: Enter new infor to 'SSN Number' textbox with value: " + editSSN);
        employeeDetailPage.enterToSSNNumberTextboxAtPersonalDetailsForm(editSSN);

        log.info("Edit Employee [Personal] - Step 05: Click to 'Gender' radio with value: " + editGender);
        employeeDetailPage.clickToGenderRadioAtPersonalDetailsForm(editGender);

        log.info("Edit Employee [Personal] - Step 06: Select to 'Marital Status' dropdown with value: " + editMaritalStatus);
        employeeDetailPage.selectMaritalStatusDropdownAtPersonalDetailsForm(editMaritalStatus);

        log.info("Edit Employee [Personal] - Step 07: Select to 'Nationality' dropdown with value: " + editNationality);
        employeeDetailPage.selectNationalityDropdownAtPersonalDetailsForm(editNationality);

        log.info("Edit Employee [Personal] - Step 08: Enter new info to 'Date of Birth' textbox with value: " + editDOB);
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
    public void Employee_03_Edit_Employee_By_Salary() {
        log.info("Edit Employee [Salary] - Step 01: Navigate to 'Salary' tab");
        employeeDetailPage.openSidebarTabByName(driver, "Salary");

        log.info("Edit Employee [Salary] - Step 02: Click to 'Add' button at 'Assigned Salary Components' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Assigned Salary Components", "Add");

        log.info("Edit Employee [Salary] - Step 03: Select 'Pay Grade' dropdown with value: " + payGrade);
        employeeDetailPage.selectPayGradeAtAddSalaryComponentForm(payGrade);

        log.info("Edit Employee [Salary] - Step 04: Enter to 'Salary Component' textbox with value: " + salaryComponent);
        employeeDetailPage.enterSalaryComponentAtAddSalaryComponentForm(salaryComponent);

        log.info("Edit Employee [Salary] - Step 05: Select 'Pay Frequency' dropdown with value: " + payFrequency);
        employeeDetailPage.selectPayFrequencyAtAddSalaryComponentForm(payFrequency);

        log.info("Edit Employee [Salary] - Step 06: Select 'Currency' dropdown with value: " + currency);
        employeeDetailPage.selectCurrencyAtAddSalaryComponentForm(currency);

        log.info("Edit Employee [Salary] - Step 07: Enter to 'Amount' textbox with value: " + amount);
        employeeDetailPage.enterAmountAtAddSalaryComponentForm(amount);

        log.info("Edit Employee [Salary] - Step 08: Enter to 'Comments' textbox with value: " + comments);
        employeeDetailPage.enterCommentsAtAddSalaryComponentForm(comments);

        log.info("Edit Employee [Salary] - Step 09: Click to 'Save' button at 'Add Salary Component' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Salary Component", "Save");

        log.info("Edit Employee [Salary] - Step 10: Verify 'Salary Component' value at table 'Add Salary Component' with value: " + salaryComponent);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "tblSalary", "Salary Component", "1", salaryComponent));

        log.info("Edit Employee [Salary] - Step 11: Verify 'Pay Frequency' value at table 'Add Salary Component' with value: " + payFrequency);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "tblSalary", "Pay Frequency", "1", payFrequency));

        log.info("Edit Employee [Salary] - Step 12: Verify 'Currency' value at table 'Add Salary Component' with value: " + currency);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "tblSalary", "Currency", "1", currency));

        log.info("Edit Employee [Salary] - Step 11: Verify 'Amount' value at table 'Add Salary Component' with value: " + amount);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "tblSalary", "Amount", "1", amount));

        log.info("Edit Employee [Salary] - Step 11: Verify 'Comments' value at table 'Add Salary Component' with value: " + comments);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "tblSalary", "Comments", "1", comments));

        log.info("Edit Employee [Salary] - Step 11: Verify 'Show Direct Deposit Details' value at table 'Add Salary Component' with value: ");
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "tblSalary", "Show Direct Deposit Details", "1", ""));
    }

    @Test
    public void Employee_04_Edit_Employee_By_Job() {
        log.info("Edit Employee [Job] - Step 01: Navigate to 'Job' tab");
        employeeDetailPage.openSidebarTabByName(driver, "Job");

        log.info("Edit Employee [Job] - Step 02: Click to 'Edit' button at 'Job' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Job", "Edit");

        log.info("Edit Employee [Job] - Step 03: Select 'Job Title' dropdown with value: " + jobTitle);
        employeeDetailPage.selectJobTitleAtJobForm(jobTitle);

        log.info("Edit Employee [Job] - Step 04: Select 'Employee Status' dropdown with value: " + employeeStatus);
        employeeDetailPage.selectEmployeeStatusAtJobForm(employeeStatus);

        log.info("Edit Employee [Job] - Step 05: Select 'Job Category' dropdown with value: " + jobCategory);
        employeeDetailPage.selectJobCategoryAtJobForm(jobCategory);

        log.info("Edit Employee [Job] - Step 06: Enter to 'Joined Date' textbox with value: " + joinedDate);
        employeeDetailPage.enterToJoinedDateAtJobForm(joinedDate);

        log.info("Edit Employee [Job] - Step 07: Select 'Sub Unit' dropdown with value: " + subUnit);
        employeeDetailPage.selectSubUnitAtJobForm(subUnit);

        log.info("Edit Employee [Job] - Step 08: Select 'Location' dropdown with value: " + location);
        employeeDetailPage.selectLocationAtJobForm(location);

        log.info("Edit Employee [Job] - Step 09: Enter to 'Start Date' textbox with value: " + startDate);
        employeeDetailPage.enterToStartDateAtJobForm(startDate);

        log.info("Edit Employee [Job] - Step 10: Enter to 'End Date' textbox with value: " + endDate);
        employeeDetailPage.enterToEndDateAtJobForm(endDate);

        log.info("Edit Employee [Job] - Step 11: Click to 'Save' button at 'Job' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Job", "Save");

        log.info("Edit Employee [Job] - Step 12: Verify 'Job Title' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getJobTitleAtJobForm(), jobTitle);

        log.info("Edit Employee [Job] - Step 13: Verify 'Employee Status' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getEmployeeStatusAtJobForm(), employeeStatus);

        log.info("Edit Employee [Job] - Step 12: Verify 'Job Category' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getJobCategoryAtJobForm(), jobCategory);

        log.info("Edit Employee [Job] - Step 12: Verify 'Joined Date' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getJoinedDateAtJobForm(), joinedDate);

        log.info("Edit Employee [Job] - Step 12: Verify 'Sub Unit' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getSubUnitAtJobForm(), subUnit);

        log.info("Edit Employee [Job] - Step 12: Verify 'Location' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getLocationAtJobForm(), location);

        log.info("Edit Employee [Job] - Step 12: Verify 'Start Date' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getStartDateAtJobForm(), startDate);

        log.info("Edit Employee [Job] - Step 12: Verify 'End Date' textbox is edited successfully");
        verifyEquals(employeeDetailPage.getEndDateAtJobForm(), endDate);
    }

    @Test
    public void Employee_05_Edit_Employee_By_Report_To() {

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
