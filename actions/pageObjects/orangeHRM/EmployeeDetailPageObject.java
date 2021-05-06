package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.EmployeeDetailPageUI;
import pageUIs.orangeHRM.OrangeHRMBasePageUI;

public class EmployeeDetailPageObject extends BasePage {
    WebDriver driver;

    public EmployeeDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextboxAtAddEmployeeForm(String firstName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_ADD_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_ADD_FORM, firstName);
    }

    public void enterToLastNameTextboxAddEmployeeForm(String lastName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_ADD_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_ADD_FORM, lastName);
    }

    public String getEmployeeIdAtAddEmployeeForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_ADD_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_ADD_FORM, "value");
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, EmployeeDetailPageUI.SAVE_BUTTON_ADD_FORM);
        clickToElement(driver, EmployeeDetailPageUI.SAVE_BUTTON_ADD_FORM);
    }

    public boolean isFullNameDisplayedAtHeader(String fullName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_PERSONAL_FORM, fullName);
        return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_PERSONAL_FORM, fullName);
    }

    public String getFirstNameDisplayedAtPersonalDetailsForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_FORM, "value");
    }

    public String getLastNameDisplayedAtPersonalDetailsForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_FORM, "value");
    }

    public String getEmployeeIDAtPersonalDetailsForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_PERSONAL_FORM, "value");
    }

    public void enterToFirstNameTextboxAtPersonalDetailsForm(String firstName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_FORM, firstName);
    }

    public void enterToLastNameTextboxAtPersonalDetailsForm(String lastName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_FORM, lastName);
    }

    public void enterToSSNNumberTextboxAtPersonalDetailsForm(String ssnNumber) {
        waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_PERSONAL_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_PERSONAL_FORM, ssnNumber);
    }

    public void clickToGenderRadioAtPersonalDetailsForm(String gender) {
        waitForElementClickable(driver, EmployeeDetailPageUI.GENDER_RADIO_PERSONAL_FORM, gender);
        clickToElement(driver, EmployeeDetailPageUI.GENDER_RADIO_PERSONAL_FORM, gender);
    }

    public void selectMaritalStatusDropdownAtPersonalDetailsForm(String maritalStatus) {
        waitForElementClickable(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_PERSONAL_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_PERSONAL_FORM, maritalStatus);
    }

    public void selectNationalityDropdownAtPersonalDetailsForm(String nationality) {
        waitForElementClickable(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_PERSONAL_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_PERSONAL_FORM, nationality);
    }

    public void enterToDateOfBirhtTextboxAtPersonalDetailsForm(String dob) {
        waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_PERSONAL_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_PERSONAL_FORM, dob);
//        clickToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_PERSONAL_FORM + OrangeHRMBasePageUI.ICON_DATE_TIME_PICKER_FOLLOWING_SIBLING);
    }

    public String getSuccessMessageAtPersonalDetailsForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_MASSAGE_AT_PERSONAL_FORM);
        return getElementText(driver, EmployeeDetailPageUI.SUCCESS_MASSAGE_AT_PERSONAL_FORM);
    }

    public String getSSNNumberDisplayedAtPersonalDetailsForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_PERSONAL_FORM, "value");
    }

    public boolean isGenderRadioSelect(String gender) {
        waitForElementVisible(driver, EmployeeDetailPageUI.GENDER_RADIO_PERSONAL_FORM, gender);
        return isElementSelected(driver, EmployeeDetailPageUI.GENDER_RADIO_PERSONAL_FORM, gender);
    }

    public String getSelectItemOfMaritalStatusDropdown() {
        waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_PERSONAL_FORM);
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_PERSONAL_FORM);
    }

    public String getSelectItemOfNationalityDropdown() {
        waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_PERSONAL_FORM);
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_PERSONAL_FORM);
    }

    public String getDateOfBirhtDisplayedAtPersonalForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_PERSONAL_FORM, "value");
    }

    public void selectPayGradeAtAddSalaryComponentForm(String payGrade) {
        waitForElementClickable(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_SALARY_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_SALARY_FORM, payGrade);
    }

    public void enterSalaryComponentAtAddSalaryComponentForm(String salaryComponent) {
        waitForElementVisible(driver, EmployeeDetailPageUI.SALARY_COMPONENT_TEXTBOX_SALARY_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.SALARY_COMPONENT_TEXTBOX_SALARY_FORM, salaryComponent);
    }

    public void selectPayFrequencyAtAddSalaryComponentForm(String payFrequency) {
        waitForElementClickable(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DROPDOWN_SALARY_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DROPDOWN_SALARY_FORM, payFrequency);
    }

    public void selectCurrencyAtAddSalaryComponentForm(String currency) {
        waitForElementClickable(driver, EmployeeDetailPageUI.CURRENCY_DROPDOWN_SALARY_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.CURRENCY_DROPDOWN_SALARY_FORM, currency);
    }

    public void enterAmountAtAddSalaryComponentForm(String amount) {
        waitForElementVisible(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_SALARY_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_SALARY_FORM, amount);
    }

    public void enterCommentsAtAddSalaryComponentForm(String comments) {
        waitForElementVisible(driver, EmployeeDetailPageUI.COMMENTS_TEXTBOX_SALARY_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.COMMENTS_TEXTBOX_SALARY_FORM, comments);
    }

    public void selectJobTitleAtJobForm(String jobTitle) {
        waitForElementClickable(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDPWN_JOB_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDPWN_JOB_FORM, jobTitle);
    }

    public void selectEmploymentStatusAtJobForm(String employeeStatus) {
        waitForElementClickable(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDPWN_JOB_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDPWN_JOB_FORM, employeeStatus);
    }

    public void selectJobCategoryAtJobForm(String jobCategory) {
        waitForElementClickable(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_JOB_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_JOB_FORM, jobCategory);
    }

    public void enterToJoinedDateAtJobForm(String joinedDate) {
        waitForElementVisible(driver, EmployeeDetailPageUI.JOIN_DATE_TEXTBOX_JOB_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.JOIN_DATE_TEXTBOX_JOB_FORM, joinedDate);
        clickToElement(driver, EmployeeDetailPageUI.JOIN_DATE_TEXTBOX_JOB_FORM + OrangeHRMBasePageUI.ICON_DATE_TIME_PICKER_FOLLOWING_SIBLING);
    }

    public void selectSubUnitAtJobForm(String subUnit) {
        waitForElementClickable(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDPWN_JOB_FORM);
//        selectItemInDropdownList(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDPWN_JOB_FORM, subUnit);
        selectItemInCustomDropdown(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDPWN_JOB_FORM, EmployeeDetailPageUI.OPTION_SUB_UNIT_DROPDPWN_JOB_FORM, subUnit.trim());
    }

    public void selectLocationAtJobForm(String location) {
        waitForElementClickable(driver, EmployeeDetailPageUI.LOCATION_DROPDPWN_JOB_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.LOCATION_DROPDPWN_JOB_FORM, location);
    }

    public void enterToStartDateAtJobForm(String startDate) {
        waitForElementVisible(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_JOB_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_JOB_FORM, startDate);
//        clickToElement(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_JOB_FORM + OrangeHRMBasePageUI.ICON_DATE_TIME_PICKER_FOLLOWING_SIBLING);
    }

    public void enterToEndDateAtJobForm(String endDate) {
        waitForElementVisible(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_JOB_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_JOB_FORM, endDate);
//        clickToElement(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_JOB_FORM + OrangeHRMBasePageUI.ICON_DATE_TIME_PICKER_FOLLOWING_SIBLING);
    }

    public String getJobTitleAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDPWN_JOB_FORM);
//        return getElementTextByAttribute(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDPWN_JOB_FORM, "value");
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDPWN_JOB_FORM);
    }

    public String getEmploymentStatusAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDPWN_JOB_FORM);
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDPWN_JOB_FORM);
    }

    public String getJobCategoryAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_JOB_FORM);
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_JOB_FORM);
    }

    public String getJoinedDateAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.JOIN_DATE_TEXTBOX_JOB_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.JOIN_DATE_TEXTBOX_JOB_FORM, "value");
    }

    public String getSubUnitAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDPWN_JOB_FORM);
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDPWN_JOB_FORM);
    }

    public String getLocationAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.LOCATION_DROPDPWN_JOB_FORM);
        return getFirstSelectedTextInDropdown(driver, EmployeeDetailPageUI.LOCATION_DROPDPWN_JOB_FORM);
    }

    public String getStartDateAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_JOB_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_JOB_FORM, "value");
    }

    public String getEndDateAtJobForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_JOB_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_JOB_FORM, "value");
    }

    public void enterToNameSuperVisorAtAddSupervisorForm(String nameSupervisor) {
        waitForElementVisible(driver, EmployeeDetailPageUI.NAME_SUPERVISOR_TEXTBOX_ADD_SUPERVISOR_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.NAME_SUPERVISOR_TEXTBOX_ADD_SUPERVISOR_FORM, nameSupervisor);
    }

    public void selectReportingMethodAtAddSupervisorForm(String reportingMethod) {
        waitForElementClickable(driver, EmployeeDetailPageUI.REPORTING_METHOD_DROPDOWN_ADD_SUPERVISOR_FORM);
        selectItemInDropdownList(driver, EmployeeDetailPageUI.REPORTING_METHOD_DROPDOWN_ADD_SUPERVISOR_FORM, reportingMethod);
    }
}
