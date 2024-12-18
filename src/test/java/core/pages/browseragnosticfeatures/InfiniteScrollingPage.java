package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;



public class InfiniteScrollingPage extends BasePage {
    @FindBy(id = "content")
    private WebElement content;


    /**
     * Checks if a specific section is visible on the page.
     *
     * @param sectionName The name or identifier of the section to check.
     * @return true if the section is visible, false otherwise.
     */
    public boolean isSectionVisible(String sectionName) {
        try {
            // Locator to find the section by `data-name` or `id`
            By sectionLocator = By.xpath(String.format("//section[@data-name='%s' or @id='%s']", sectionName, sectionName));
            WebElement section = driver.findElement(sectionLocator);
            return section.isDisplayed();
        } catch (Exception e) {
            return false; // Handle any exceptions (e.g., NoSuchElementException)
        }
    }

    /**
     * Scrolls to the bottom of the content area using JavaScript.
     */
    public void scrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight);", content);
            Thread.sleep(1000); // Allow time for content to load dynamically
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
            // Sleep for 1 second to wait for new content to load (replaceable with more efficient waits if needed)
            Thread.sleep(1000);
            int newHeight = content.getSize().getHeight();
            return newHeight > initialHeight;
        } catch (Exception e) {
            return false; // Return false if new content is not detected
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

}
