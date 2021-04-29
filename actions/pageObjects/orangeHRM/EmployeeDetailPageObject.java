package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageUIs.orangeHRM.EmployeeDetailPageUI;

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
}
