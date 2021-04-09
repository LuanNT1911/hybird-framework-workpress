package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
//	PageGeneratorManager pageGenerator;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
//		pageGenerator = PageGeneratorManager.getPageGenerator();
	}

    public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX, email);
    }

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
