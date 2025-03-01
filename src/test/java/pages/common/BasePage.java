package pages.common;

import core.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();  // Assuming DriverManager is set up to return a WebDriver instance
        PageFactory.initElements(driver, this);
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }
}
