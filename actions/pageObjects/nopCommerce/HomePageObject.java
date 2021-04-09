package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
//	PageGeneratorManager pageGenerator;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
//		pageGenerator = PageGeneratorManager.getPageGenerator();
	}

	public RegisterPageObject clickToResgisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACOUNT_LINK);
	}

    public CustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACOUNT_LINK);
		return  PageGeneratorManager.getCustomerInforPage(driver);
    }
}
