package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage {
    WebDriver driver;

    public EmployeeDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_ADD_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_ADD_FORM, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_ADD_FORM);
        sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_ADD_FORM, lastName);
    }

    public String getEmployeeIdAtAddForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_ADD_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_ADD_FORM);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, EmployeeDetailPageUI.SAVE_BUTTON_ADD_FORM);
        clickToElement(driver, EmployeeDetailPageUI.SAVE_BUTTON_ADD_FORM);
    }

    public boolean isFullNameDisplayedAtHeader(String fullName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_PERSONAL_FORM, fullName);
        return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_HEADER_TEXT_PERSONAL_FORM, fullName);
    }

    public String getFirstNameDisplayedAtPersonalForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_FORM);
    }

    public String getLastNameDisplayedAtPersonalForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_FORM);
    }

    public String getEmployeeIDAtPersonalForm() {
        waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_PERSONAL_FORM);
        return getElementTextByAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_PERSONAL_FORM);
    }
}
