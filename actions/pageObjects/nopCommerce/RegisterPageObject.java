package pageObjects.nopCommerce;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check to Gender checkbox: {0}")
    public void checkToGenderCheckbox(String gender){
        String valueGender = null;
        if(gender.equalsIgnoreCase("male")){
            valueGender = "M";
        }else if(gender.equalsIgnoreCase("female")){
            valueGender = "F";
        }
        waitForElementClickable(driver, RegisterPageUI.GENDER_CHECKBOX,valueGender);
        clickToElement(driver, RegisterPageUI.GENDER_CHECKBOX,valueGender);
    }

    @Step("Input to First Name textbox: {0}")
    public void inputToFirstNameTextbox(String firstName) {
        waitForPageLoadingCompleted(driver);
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        isElementUndisplayed(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Input to Last Name textbox: {0}")
    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Input to Email textbox: {0}")
    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Input to Password textbox: {0}")
    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Input to Confirm Password textbox: {0}")
    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Verify Success Message is displayed")
    public boolean isSuccessMessageDisplayed() {
//		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
        return !isElementUndisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
    }

}
