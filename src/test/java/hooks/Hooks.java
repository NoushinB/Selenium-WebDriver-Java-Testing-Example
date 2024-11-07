package hooks;

import core.drivers.DriverManager;
import core.drivers.DriverProvider;
import core.library.Constants;
import core.library.PropertyLoader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @BeforeAll
    public static void setup() {
        // Any global setup for web testing
        PropertyLoader.getInstance().setBrowser(Constants.Browser.CHROME);
        PropertyLoader.getInstance().setBaseUrl(Constants.Urls.BASE_URL);
    }

    @Before
    public static void beforeTest() {
        DriverProvider driverProvider = new DriverProvider();
        WebDriver driver = driverProvider.getDriver();
        DriverManager.setDriver(driver);
    }

    @After
    public static void afterTest() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverManager.removeDriver();
    }

    @AfterAll
    public static void teardown() {
        // Any global cleanup after all tests
    }
}


