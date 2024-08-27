package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFormComponentsPage extends BasePage {

    @FindBy(id = "my-text-id")
    private WebElement textInput;
    @FindBy(xpath = "//input[@name='my-password']")
    private WebElement password;
}
