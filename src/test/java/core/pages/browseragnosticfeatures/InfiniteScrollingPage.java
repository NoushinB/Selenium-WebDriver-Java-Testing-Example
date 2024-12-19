package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfiniteScrollingPage extends BasePage {
    @FindBy(id = "content")
    private WebElement content;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public InfiniteScrollingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Checks if a specific section is visible on the page.
     *
     * @param sectionName The name or identifier of the section to check.
     * @return true if the section is visible, false otherwise.
     */
    public boolean isSectionVisible(String sectionName) {
        try {
            By sectionLocator = By.xpath(String.format("//section[@data-name='%s' or @id='%s']", sectionName, sectionName));
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionLocator));
            return section.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Scrolls to the bottom of the content area using JavaScript.
     */
    public void scrollToBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            boolean isScrollable = (Boolean) js.executeScript(
                    "return arguments[0].scrollHeight > arguments[0].clientHeight;", content);

            if (isScrollable) {
                js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", content);
            } else {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            }

            Thread.sleep(1000); // Allow time for dynamic content to load
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll to the bottom of the content area.", e);
        }
    }

    /**
     * Checks if new content is loaded dynamically by comparing content size.
     *
     * @return true if new content is loaded, false otherwise.
     */
    public boolean isNewContentLoaded() {
        try {
            int initialHeight = content.getSize().getHeight();
            scrollToBottom();
            Thread.sleep(1000); // Allow time for dynamic content to load
            int newHeight = content.getSize().getHeight();
            return newHeight > initialHeight;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the current height of the content area.
     *
     * @return the height of the content area.
     */
    public int getContentHeight() {
        return content.getSize().getHeight();
    }

    /**
     * Gets the current page URL.
     *
     * @return the current URL of the page.
     */
    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }
}