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



}
