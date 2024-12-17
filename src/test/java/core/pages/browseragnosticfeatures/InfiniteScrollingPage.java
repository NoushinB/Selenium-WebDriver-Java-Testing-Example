package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class InfiniteScrollingPage extends BasePage {
    @FindBy(id = "content")
    private WebElement content;

}
