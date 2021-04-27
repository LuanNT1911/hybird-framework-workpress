package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmployeeDetailPageObject extends BasePage {
    WebDriver driver;

    public EmployeeDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
