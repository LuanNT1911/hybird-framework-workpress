package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.List;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName)) {
				status = true;
			} else {
				return status;
			}
		}
		return status;
	}

	public void clickToStartUploadButton() {
		List<WebElement> uploadButtons = getListWebElement(driver, HomePageUI.START_UPLOAD_BUTTON);
		for (WebElement uploadBtn : uploadButtons) {
			uploadBtn.click();
			sleepInSeconds(2);
		}
	}

	public boolean areFileUploadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME, fileName)) {
				status = true;
			} else {
				return status;
			}
		}
		return status;
	}

	public void uploadFiles(String... fileName){
		uploadMultipleFiles(driver, HomePageUI.UPLOAD_FILE_TYPE, fileName);
	}

}
