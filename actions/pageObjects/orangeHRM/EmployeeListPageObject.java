package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {
    WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeDetailPageObject clickToAddButton() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
        clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
        return PageGeneratorManager.getEmployeeDetailPage(driver);
    }

    public void enterToEmployeeName(String employeeName) {
        sleepInSeconds(1);
        waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
    }

    public void enterToId(String employeeID) {
        waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
        sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
    }

    public void selectEmployeeStatus(String employeeStatus) {
        waitForElementClickable(driver, EmployeeListPageUI.EMPLOYEE_STATUS_DROPDOWN);
        selectItemInDropdownList(driver, EmployeeListPageUI.EMPLOYEE_STATUS_DROPDOWN, employeeStatus);
    }

    public void selectInclude(String include) {
        waitForElementClickable(driver, EmployeeListPageUI.INCLUDE_DROPDOWN);
        selectItemInDropdownList(driver, EmployeeListPageUI.INCLUDE_DROPDOWN, include);
    }

    public void enterToSupervisor(String nameSupervisor) {
        waitForElementVisible(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX);
        sendkeyToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX, nameSupervisor);
    }

    public void selectJobTitle(String jobTitle) {
        waitForElementClickable(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN);
        selectItemInDropdownList(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN, jobTitle);
    }

    public void selectSubUnit(String subUnit) {
        waitForElementClickable(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN);
        selectItemInDropdownList(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN, subUnit);
    }

    public boolean isNoRecordFoundDisplayed(String tableID) {
        waitForElementVisible(driver, EmployeeListPageUI.NO_RECORD_FOUND_TEXT_AT_TABLE_ID, tableID);
        return isElementDisplayed(driver, EmployeeListPageUI.NO_RECORD_FOUND_TEXT_AT_TABLE_ID, tableID);
    }
}
