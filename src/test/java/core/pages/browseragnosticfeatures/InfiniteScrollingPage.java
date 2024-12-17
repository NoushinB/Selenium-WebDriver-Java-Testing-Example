package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class InfiniteScrollingPage extends BasePage {
    @FindBy(id = "content")
    private WebElement content;

    /**
     * Scrolls down to the bottom of the page using JavaScript.
     */
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Waits for new content to load after scrolling.
     *
     * @param previousContentLength Length of the content before scrolling.
     * @param timeoutSeconds        Timeout in seconds to wait for new content.
     * @return true if new content is loaded, false otherwise.
     */
    public boolean waitForNewContent(int previousContentLength, int timeoutSeconds) {
        for (int i = 0; i < timeoutSeconds; i++) {
            int currentContentLength = content.getText().length();
            if (currentContentLength > previousContentLength) {
                return true;
            }
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return false;
    }

    /**
     * Performs infinite scrolling until the end of the page.
     *
     * @param timeoutSeconds Maximum timeout to wait for new content.
     */
    public void performInfiniteScroll(int timeoutSeconds) {
        int previousContentLength = 0;
        while (true) {
            scrollToBottom();
            if (!waitForNewContent(previousContentLength, timeoutSeconds)) {
                break; // Exit if no new content is loaded within the timeout.
            }
            previousContentLength = content.getText().length();
        }
    }


}
