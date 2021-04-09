package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    public void isBeingLoginPage(){
        waitForTitleContains(driver, "Login");
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(emailTextbox, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(passwordTextbox, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(loginButton);
    }
}
