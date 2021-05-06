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
    String jobTitle, employmentStatus, jobCategory, joinedDate, subUnit, location, startDate, endDate;
    String nameSupervisor, reportingMethod;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        firstName = "Now " + getRandomNumber();
        lastName = "Beamin " + getRandomNumber();

        editFirstName = "Future" + getRandomNumber();
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
        employmentStatus = "Full-Time Contract";
        jobCategory = "Technicians";
        joinedDate = "2020-09-07";
        subUnit = "  Quality Assurance";
        location = "New York Sales Office";
        startDate = "2020-11-07";
        endDate = "2021-11-07";

        nameSupervisor = "Aaliyah Haq";
        reportingMethod = "Direct";

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

        log.info("Edit Employee [Job] - Step 04: Select 'Employment Status' dropdown with value: " + employmentStatus);
        employeeDetailPage.selectEmploymentStatusAtJobForm(employmentStatus);

        log.info("Edit Employee [Job] - Step 05: Select 'Job Category' dropdown with value: " + jobCategory);
        employeeDetailPage.selectJobCategoryAtJobForm(jobCategory);

        log.info("Edit Employee [Job] - Step 06: Select 'Sub Unit' dropdown with value: " + subUnit);
        employeeDetailPage.selectSubUnitAtJobForm(subUnit);

        log.info("Edit Employee [Job] - Step 07: Select 'Location' dropdown with value: " + location);
        employeeDetailPage.selectLocationAtJobForm(location);

        log.info("Edit Employee [Job] - Step 08: Enter to 'Joined Date' textbox with value: " + joinedDate);
        employeeDetailPage.enterToJoinedDateAtJobForm(joinedDate);

        log.info("Edit Employee [Job] - Step 09: Enter to 'Start Date' textbox with value: " + startDate);
        employeeDetailPage.enterToStartDateAtJobForm(startDate);

        log.info("Edit Employee [Job] - Step 10: Enter to 'End Date' textbox with value: " + endDate);
        employeeDetailPage.enterToEndDateAtJobForm(endDate);

        log.info("Edit Employee [Job] - Step 11: Click to 'Save' button at 'Job' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Job", "Save");

        log.info("Edit Employee [Job] - Step 12: Verify 'Job Title' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getJobTitleAtJobForm(), jobTitle);

        log.info("Edit Employee [Job] - Step 13: Verify 'Employee Status' dropdown is edited successfully");
        verifyEquals(employeeDetailPage.getEmploymentStatusAtJobForm(), employmentStatus);

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
        log.info("Edit Employee [Report-to] - Step 01: Navigate to 'Report-to' tab");
        employeeDetailPage.openSidebarTabByName(driver, "Report-to");

        log.info("Edit Employee [Report-to] - Step 02: Click to 'Edit' button at 'Assigned Supervisors' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Assigned Supervisors", "Add");

        log.info("Edit Employee [Report-to] - Step 03: Enter to 'Name' textbox with value: " + nameSupervisor);
        employeeDetailPage.enterToNameSuperVisorAtAddSupervisorForm(nameSupervisor);

        log.info("Edit Employee [Report-to] - Step 04: Select 'Reporting Method ' dropdown with value: " + reportingMethod);
        employeeDetailPage.selectReportingMethodAtAddSupervisorForm(reportingMethod);

        log.info("Edit Employee [Report-to] - Step 05: Click to 'Save' button at 'Add Supervisor' form");
        employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Supervisor", "Save");

        log.info("Edit Employee [Report-to] - Step 06: Verify 'Name' value at table 'Assigned Supervisors' with value: " + nameSupervisor);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "sup_list", "Name", "1", nameSupervisor));

        log.info("Edit Employee [Report-to] - Step 07: Verify 'Reporting Method' value at table 'Assigned Supervisors' with value: " + reportingMethod);
        verifyTrue(employeeDetailPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "sup_list", "Reporting Method", "1", reportingMethod));
    }

    @Test
    public void Employee_06_Add_User_To_Employee() {

    }

    @Test
    public void Employee_07_Search_User() {
        log.info("Search User - Step 01: Navigate to Employee List");
//        dashboardPage.openDynamicMenuPage(driver, "PIM");
        employeeDetailPage.openDynamicMenuPage(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

//        employeeID = "0282";
//        editFirstName = "Future85708";
//        editLastName = "Grab92690";
        String employeeName = editFirstName + " " + editLastName;

        //** Searching with Employee Name
        log.info("Search User - Step 01: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 02: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 03: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        //** Searching with Employee ID
        log.info("Search User - Step 04: Enter to 'Id' textbox with value: " + employeeID);
        employeeListPage.enterToId(employeeID);

        log.info("Search User - Step 05: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 06: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        log.info("Search User - Step 07: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Employment Status
        log.info("Search User - Step 08: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 09: Select 'Employment Status' with value: " + employmentStatus);
        employeeListPage.selectEmployeeStatus(employmentStatus);

        log.info("Search User - Step 10: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 11: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        log.info("Search User - Step 12: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Include: Current Employees Only
        log.info("Search User - Step 13: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 14: Select 'Include' dropdown with value: 'Current Employees Only'");
        employeeListPage.selectInclude("Current Employees Only");

        log.info("Search User - Step 15: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 16: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        log.info("Search User - Step 17: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Include: Current and Past Employees
        log.info("Search User - Step 18: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 19: Select 'Include' dropdown with value: 'Current and Past Employees'");
        employeeListPage.selectInclude("Current and Past Employees");

        log.info("Search User - Step 20: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 21: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        log.info("Search User - Step 22: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Include: Past Employees Only
        log.info("Search User - Step 23: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 24: Select 'Include' dropdown with value: 'Past Employees Only'");
        employeeListPage.selectInclude("Past Employees Only");

        log.info("Search User - Step 25: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 26: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isNoRecordFoundDisplayed("resultTable"));

        log.info("Search User - Step 27: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Supervisor Name
        log.info("Search User - Step 28: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 29: Enter to 'Supervisor' textbox with value: " + nameSupervisor);
        employeeListPage.enterToSupervisor(nameSupervisor);

        log.info("Search User - Step 30: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 31: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        log.info("Search User - Step 32: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Job Title
        log.info("Search User - Step 33: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 34: Select 'Job Title' textbox with value: " + jobTitle);
        employeeListPage.selectJobTitle(jobTitle);

        log.info("Search User - Step 35: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 36: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

        log.info("Search User - Step 37: Click to 'Reset' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Reset");

        //** Searching with Employee Name + Sub Unit
        log.info("Search User - Step 38: Enter to 'Employee Name' textbox with value: " + employeeName);
        employeeListPage.enterToEmployeeName(employeeName);

        log.info("Search User - Step 39: Select 'Sub Unit' textbox with value: " + subUnit);
        employeeListPage.selectSubUnit(subUnit);

        log.info("Search User - Step 40: Click to 'Search' button at 'Employee Information' form");
        employeeListPage.clickToButtonByNameAtFormHeader(driver, "Employee Information", "Search");

        log.info("Search User - Step 41: Verify Employee Information is displayed correctly");
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Id", "1", employeeID));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Last Name", "1", editLastName));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Employment Status", "1", employmentStatus));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Sub Unit", "1", subUnit));
        verifyTrue(employeeListPage.isInformationInTableAtColumnNameIndexAndRowIndex(driver, "resultTable", "Supervisor", "1", nameSupervisor));

//
//        log.info("Search User - Step 01: Enter to 'Id' textbox with value: " + employeeID);
//        employeeListPage.enterToId(employeeID);

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
//        closeBrowserAndDriver(driver);
    }
}
