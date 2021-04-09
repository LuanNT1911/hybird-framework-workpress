package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
    private WebElement registerSuccessMsg;

    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logoutLink;


    public void inputToFirstNameTextbox(String firstName) {
        waitForElementClickable(driver, firstNameTextbox);
        waitForElementVisible(driver, firstNameTextbox);
        sendkeyToElement(firstNameTextbox, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendkeyToElement(lastNameTextbox, lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(emailTextbox, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(passwordTextbox, password);
    }

    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendkeyToElement(confirmPasswordTextbox, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, registerSuccessMsg);
        return isElementDisplayed(registerSuccessMsg);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(logoutLink);
    }
}
