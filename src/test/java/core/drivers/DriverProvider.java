package core.drivers;

import core.library.Constants;
import core.library.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverProvider {
    private WebDriver driver;

    private final PropertyLoader properties = PropertyLoader.getInstance();

    /*Returns the WebDriver instance. Initializes it if not already done.
     */
    public WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    /*
    Initializes the WebDriver based on the browser type specified in PropertyLoader.
     */
    private void initializeDriver() {
        String browser = properties.getBrowser();

        switch (browser.toLowerCase()) {
            case Constants.Browser.CHROME:
                initializeChromeDriver();
                break;
            case Constants.Browser.FIREFOX:
                initializeFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Initializes the ChromeDriver.
     */
    private void initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/dev/drivers/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
    }

    /**
     * Initializes the FirefoxDriver.
     */
    private void initializeFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "D:/drivers/geckodriver-v0.34.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
    }
}
