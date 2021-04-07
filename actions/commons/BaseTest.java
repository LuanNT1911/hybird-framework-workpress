package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String prjLocation = System.getProperty("user.dir");
    private String osName = System.getProperty("os.name");

    protected WebDriver getBrowserDriver(String browserName) {
        setBrowserDriver();
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge_chormium")) {
            driver = new EdgeDriver();
        } else {
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
}
