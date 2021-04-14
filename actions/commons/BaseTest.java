package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String prjLocation = GlobalConstants.PROJECT_LOCATION;
    private String osName = GlobalConstants.OS_NAME;

    protected WebDriver getBrowserDriver(String browserName, String url) {
//        setBrowserDriver();
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE_CHROMIUM:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Not found the browser name!");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName) {
//        setBrowserDriver();
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE_CHROMIUM:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Not found the browser name!");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    private void setBrowserDriver() {
        String browserFolderPath = prjLocation + getDirectorySlash("browserDrivers");
        if (isWindow()) {
            System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver.exe");
            System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver.exe");
        } else if (isMac()) {
            System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_mac");
            System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver_mac");
            System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver_mac");
        }
    }

    private String getDirectorySlash(String folderName) {
        if (isMac() || isUnix()) {
            folderName = "/" + folderName + "/";
        } else if (isWindow()) {
            folderName = "\\" + folderName + "\\";
        } else {
            folderName = null;
        }
        return folderName;
    }

    private boolean isWindow() {
        return (osName.toLowerCase().indexOf("win") >= 0);
    }

    private boolean isMac() {
        return (osName.toLowerCase().indexOf("mac") >= 0);
    }

    private boolean isUnix() {
        return (osName.toLowerCase().indexOf("nix") >= 0);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
//            if (condition == true) {
//                log.info(" -------------------------- PASSED -------------------------- ");
//            } else {
//                log.info(" -------------------------- FAILED -------------------------- ");
//            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
//            if (condition == false) {
//                log.info(" -------------------------- PASSED -------------------------- ");
//            } else {
//                log.info(" -------------------------- FAILED -------------------------- ");
//            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
//            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
//            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
}
