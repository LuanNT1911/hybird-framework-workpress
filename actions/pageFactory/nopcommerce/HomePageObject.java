package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //    @FindBy(how = How.XPATH, using = "//a[text()='Register']")
    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[text()='My account']")
    private WebElement myAccountLink;

    public void clickToResgisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(loginLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(myAccountLink);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, myAccountLink);
        return isElementDisplayed(myAccountLink);
    }
}
