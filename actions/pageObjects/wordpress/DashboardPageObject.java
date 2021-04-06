package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.DashboardPageUI;

public class DashboardPageObject extends BasePage {

	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderTextDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
	}

}
