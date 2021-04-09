package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.CustomerInforPageUI;
import pageUIs.nopCommerce.LoginPageUI;

public class CustomerInforPageObject extends BasePage {
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementText(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementText(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementText(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
	}
}
