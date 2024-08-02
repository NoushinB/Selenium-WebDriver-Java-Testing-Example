package core.library;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUIMethods {
    protected final WebDriver driver;

    public ReusableUIMethods(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
