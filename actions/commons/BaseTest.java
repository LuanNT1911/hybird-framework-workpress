package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

// Class chứa các hàm dùng chung cho các tầng testcases (class trong testcases)
public class BaseTest {
    WebDriver driver;
    String prjLocation = System.getProperty("user.dir");

    public WebDriver getBrowserDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", prjLocation + "\\browserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", prjLocation + "\\browserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge_chormium")) {
            System.setProperty("webdriver.edge.driver", prjLocation + "\\browserDrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Not found the browser name!");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
