package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.LoginPageUI;

public class LoginPageObject extends BasePage{
	
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String usernameOrEmail) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, usernameOrEmail);
		
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public String isErrorMessageDisplayed() {
		waitForElementClickable(driver, LoginPageUI.ERROR_MSG);
		return getElementText(driver, LoginPageUI.ERROR_MSG);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
}
