package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.Alert;
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
    private WebElement getButton(String buttonName) {
        return switch (buttonName) {
            case "Launch alert" -> launchAlertButton;
            case "Launch confirm" -> launchConfirmButton;
            case "Launch prompt" -> launchPromptButton;
            case "Launch modal" -> launchModalButton;
            default -> throw new IllegalArgumentException("Invalid button name: " + buttonName);
        };
    }

    public void clickOnButton(String buttonName) {
        getButton(buttonName).click();
    }
    public String getAlertText() {
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        // Get the text of the alert
        return alert.getText();
    }
}
