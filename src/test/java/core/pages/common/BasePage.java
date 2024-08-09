package core.pages.common;

import core.drivers.DriverManager;
import core.library.ReusableMethods;
import core.library.ReusableUIMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected ReusableMethods reusableMethods;
    protected ReusableUIMethods reusableUIMethods;

    public BasePage() {
        this.driver = DriverManager.getDriver();  // Assuming DriverManager is set up to return a WebDriver instance
        PageFactory.initElements(driver, this);
        reusableMethods = new ReusableMethods();
        reusableUIMethods = new ReusableUIMethods(driver);
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }
}
