package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfiniteScrollingPage extends BasePage {
    @FindBy(id = "content")
    private WebElement content;

    public boolean isInfiniteScrollContentVisible() {
        try {
            return content.isDisplayed();
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