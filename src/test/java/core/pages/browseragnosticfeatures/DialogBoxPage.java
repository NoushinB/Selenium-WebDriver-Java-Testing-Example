package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialogBoxPage extends BasePage {

    // Finding the alert button by its ID
    @FindBy(id = "my-alert")
    private WebElement launchAlertButton;

    // Finding the confirm button by its ID
    @FindBy(id = "my-confirm")
    private WebElement launchConfirmButton;

    // Finding the prompt button by its ID
    @FindBy(id = "my-prompt")
    private WebElement launchPromptButton;

    // Finding the modal button by its ID
    @FindBy(id = "my-modal")
    private WebElement launchModalButton;

    // Finding the text elements that display the results of confirm, prompt, and modal actions
    @FindBy(id = "confirm-text")
    private WebElement confirmText;

    @FindBy(id = "prompt-text")
    private WebElement promptText;

    @FindBy(id = "modal-text")
    private WebElement modalText;

    // Click a button
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "launchAlertButton":
                launchAlertButton.click();
                break;
            case "launchConfirmButton":
                launchConfirmButton.click();
                break;
            case "launchPromptButton":
                launchPromptButton.click();
                break;
            case "launchModalButton":
                launchModalButton.click();
                break;
            default:
                throw new IllegalArgumentException("Button name not recognized: " + buttonName);
        }
    }
}
