package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    private long longTimeout = 10;

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendkeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public void closeAllWindowsExceptParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allIds = driver.getWindowHandles();

        for (String id : allIds) {
            System.out.println("Current ID: " + id);
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allIds = driver.getWindowHandles();

        for (String id : allIds) {
            driver.switchTo().window(id);
            String currentWindowTitle = driver.getTitle();
            if (currentWindowTitle.equals(title)) {
                break;
            }
        }
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendkeyToElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public String getElementText(WebElement element) {
        return element.getText().trim();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForTitleContains(WebDriver driver, String titleContain) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.titleContains(titleContain));
    }

    public void sleepInSeconds(long millis) {
        try {
            Thread.sleep(millis * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
