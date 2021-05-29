package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.orangeHRM.OrangeHRMBasePageUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private WebDriverWait explicitWait;

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

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        return driver.findElements(getByXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String value) {
        WebElement element = getWebElement(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    public void sendkeyToElement(WebDriver driver, String dynamicLocator, String value, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        WebElement element = getWebElement(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    public void selectItemInDropdownList(WebDriver driver, String locator, String value) {
        Select select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(value);
    }

    public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
                                           String expectedItem) {
        clickToElement(driver, parentLocator);
        sleepInSeconds(1);

        explicitWait = new WebDriverWait(driver, longTimeout);
        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSeconds(1);

                clickToElement(item);
//                sleepInSeconds(1);
                break;
            }
        }
    }

    public void sleepInSeconds(long millis) {
        try {
            Thread.sleep(millis * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText().trim();
    }

    public String getElementText(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        return getWebElement(driver, locator).getText().trim();
    }

    public String getElementTextByAttribute(WebDriver driver, String locator, String attribute) {
        return getWebElement(driver, locator).getAttribute(attribute).trim();
    }

    public String getElementTextByAttribute(WebDriver driver, String dynamicLocator, String attribute, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        return getWebElement(driver, locator).getAttribute(attribute).trim();
    }

    public String getAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public int getElementSize(WebDriver driver, String locator) {
        return getListWebElement(driver, locator).size();
    }

    public int getElementSize(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        return getListWebElement(driver, locator).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        try {
            return getWebElement(driver, locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        try {
            return getWebElement(driver, locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, shortTimeout);
        List<WebElement> elements = getListWebElement(driver, locator);
        overrideGlobalTimeout(driver, longTimeout);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String dynamicLocator, String... param) {
        overrideGlobalTimeout(driver, shortTimeout);
        List<WebElement> elements = getListWebElement(driver, dynamicLocator, param);
        overrideGlobalTimeout(driver, longTimeout);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        return getWebElement(driver, locator).isSelected();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        Actions action = new Actions(driver);
        action.doubleClick(getWebElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        Actions action = new Actions(driver);
        action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, locator), key).perform();
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor
                .executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, 15);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
                getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, locator));
        return status;
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        overrideGlobalTimeout(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
        overrideGlobalTimeout(driver, longTimeout);
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String dynamicLocator, String... param) {
        String locator = getDynamicLocator(dynamicLocator, param);
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForPageLoadingCompleted(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, 15);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").equals("complete");
            }
        };
        explicitWait.until(jQueryLoad);
    }

    public String getDynamicLocator(String locator, String... values) {
        return String.format(locator, (Object[]) values);
    }

    public HomePageObject clickToLogoutLink(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
        clickToElement(driver, BasePageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    public LoginPageObject clickToLoginLink(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.LOGIN_LINK);
        clickToElement(driver, BasePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public void openDynamicMorePage(WebDriver driver, String location, String pageName) {
        waitForElementClickable(driver, BasePageUI.PAGE_LINK, location, pageName);
        clickToElement(driver, BasePageUI.PAGE_LINK, location, pageName);
    }

    public BasePage openDynamicPage(WebDriver driver, String location, String pageName) {
        waitForElementClickable(driver, BasePageUI.PAGE_LINK, location, pageName);
        clickToElement(driver, BasePageUI.PAGE_LINK, location, pageName);
        switch (pageName) {
            case "Log in":
                return PageGeneratorManager.getLoginPage(driver);
            case "Register":
                return PageGeneratorManager.getRegisterPage(driver);
            case "My account":
                return PageGeneratorManager.getCustomerInforPage(driver);
            case "Shopping cart":
                return PageGeneratorManager.getShoppingCartPage(driver);
            default:
                return PageGeneratorManager.getHomePage(driver);
        }
    }

    public String getDirectorySlash(String folderName) {
        String separator = System.getProperty("file.separator");
        return separator + folderName + separator;
    }

    public void uploadMultipleFiles(WebDriver driver, String locator, String... fileNames) {
        String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFiles");
        String fullFileName = "";

        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();

        getWebElement(driver, locator).sendKeys(fullFileName);
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public void clickRadioButtonById(WebDriver driver, String radioButtonId) {
        waitForElementClickable(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioButtonId);
        clickToElement(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioButtonId);
    }

    public void inputToTextboxById(WebDriver driver, String textboxId, String value) {
        waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_ID, textboxId);
        sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_ID, value, textboxId);
    }

    public void clickToButtonByValue(WebDriver driver, String buttonValue) {
        waitForElementVisible(driver, BasePageUI.BUTTON_BY_VALUE, buttonValue);
        clickToElement(driver, BasePageUI.BUTTON_BY_VALUE, buttonValue);
    }

    public String getTextFromTextboxById(WebDriver driver, String textboxId) {
        waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_ID, textboxId);
        return getElementTextByAttribute(driver, BasePageUI.TEXT_BOX_BY_ID,"value", textboxId);
    }

    public boolean isRadioButtonCheckedById(WebDriver driver, String radioButtonId) {
        waitForElementVisible(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioButtonId);
        return isElementSelected(driver, BasePageUI.RADIO_BUTTON_BY_ID, radioButtonId);
    }

    public boolean isDataSortAscending(WebDriver driver, String locator) {
        List<WebElement> elementList = driver.findElements(getByXpath(locator));

        ArrayList<String> dataList = new ArrayList<String>();
        for (WebElement element : elementList) {
            dataList.add(element.getText());
        }

        ArrayList<String> sortedList = new ArrayList<String>();
        for (String child : dataList) {
            sortedList.add(child);
        }
        Collections.sort(sortedList);

        return sortedList.equals(dataList);
    }

    public boolean isDataSortDesceding(WebDriver driver, String locator) {
        List<WebElement> elementList = driver.findElements(getByXpath(locator));

        ArrayList<String> dataList = new ArrayList<String>();
        for (WebElement element : elementList) {
            dataList.add(element.getText());
        }

        ArrayList<String> sortedList = new ArrayList<String>();
        for (String child : dataList) {
            sortedList.add(child);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
//        Collections.sort(dataList, Collections.reverseOrder());

        return sortedList.equals(dataList);
    }

    public boolean isDataFloatSortAscending(WebDriver driver, String locator) {
        List<WebElement> elementList = driver.findElements(getByXpath(locator));

        ArrayList<Float> dataList = new ArrayList<Float>();
        for (WebElement element : elementList) {
            dataList.add(Float.parseFloat(element.getText().replace("$", "")));
        }

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : dataList) {
            sortedList.add(child);
        }
        Collections.sort(sortedList);

        return sortedList.equals(dataList);
    }

    public boolean isDataFloatSortDescending(WebDriver driver, String locator) {
        List<WebElement> elementList = driver.findElements(getByXpath(locator));

        ArrayList<Float> dataList = new ArrayList<Float>();
        for (WebElement element : elementList) {
            dataList.add(Float.parseFloat(element.getText().replace("$", "")));
        }

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : dataList) {
            sortedList.add(child);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.equals(dataList);
    }

    public boolean isDataDateSortAscending(WebDriver driver, String locator) {
        List<WebElement> elementList = driver.findElements(getByXpath(locator));

        ArrayList<Date> dataList = new ArrayList<Date>();
        for (WebElement element : elementList) {
            dataList.add(convertStringToDate(element.getText()));
        }

        ArrayList<Date> sortedList = new ArrayList<Date>();
        for (Date child : dataList) {
            sortedList.add(child);
        }
        Collections.sort(sortedList);

        return sortedList.equals(dataList);
    }

    public boolean isDataDateSortDescending(WebDriver driver, String locator) {
        List<WebElement> elementList = driver.findElements(getByXpath(locator));

        ArrayList<Date> dataList = new ArrayList<Date>();
        for (WebElement element : elementList) {
            dataList.add(convertStringToDate(element.getText()));
        }

        ArrayList<Date> sortedList = new ArrayList<Date>();
        for (Date child : dataList) {
            sortedList.add(child);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.equals(dataList);
    }

    public Date convertStringToDate(String dateInString) {
        dateInString = dateInString.replace(",", "");
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
     * Orange HRM Project
     * */

    public void openDynamicMenuPage(WebDriver driver, String pageName) {
        sleepInSeconds(1);
        waitForElementClickable(driver, OrangeHRMBasePageUI.DYNAMIC_MENU_LINK, pageName);
        clickToElement(driver, OrangeHRMBasePageUI.DYNAMIC_MENU_LINK, pageName);
    }

    public void openSidebarTabByName(WebDriver driver, String tabName) {
        waitForElementClickable(driver, OrangeHRMBasePageUI.DYNAMIC_SIDEBAR_TAB_LINK, tabName);
        clickToElement(driver, OrangeHRMBasePageUI.DYNAMIC_SIDEBAR_TAB_LINK, tabName);
    }

    public void clickToButtonByNameAtFormHeader(WebDriver driver, String headerName, String buttonName) {
        waitForElementClickable(driver, OrangeHRMBasePageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, headerName, buttonName);
        clickToElement(driver, OrangeHRMBasePageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, headerName, buttonName);
//        if(buttonName.equalsIgnoreCase("Search")){
//            waitForElementInvisible(driver, OrangeHRMBasePageUI.TEXTBOX_LOADING);
//        }
    }

    public boolean isInformationInTableAtColumnNameIndexAndRowIndex(WebDriver driver, String tableId, String columnName, String rowIndex, String expectedValue) {
        int columnNameIndex = getElementSize(driver, OrangeHRMBasePageUI.DYNAMIC_TABLE_COLUMN_NAME_PRECEDING_SIBLING, tableId, columnName) + 1;
        String cellValue = getElementText(driver, OrangeHRMBasePageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX, tableId, rowIndex, String.valueOf(columnNameIndex));
        return cellValue.equals(expectedValue.trim());
    }
}
