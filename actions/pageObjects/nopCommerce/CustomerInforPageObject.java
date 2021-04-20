package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.CustomerInforPageUI;
import pageUIs.nopCommerce.RegisterPageUI;

public class CustomerInforPageObject extends BasePage {
    WebDriver driver;

    public CustomerInforPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isGenderCheckboxChecked(String gender) {
        String valueGender = null;
        if (gender.equalsIgnoreCase("male")) {
            valueGender = "M";
        } else if (gender.equalsIgnoreCase("female")) {
            valueGender = "F";
        }
        waitForElementVisible(driver, RegisterPageUI.GENDER_CHECKBOX, valueGender);
        return isElementSelected(driver, RegisterPageUI.GENDER_CHECKBOX, valueGender);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
        return getElementTextByAttribute(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
        return getElementTextByAttribute(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
        return getElementTextByAttribute(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
    }
}
