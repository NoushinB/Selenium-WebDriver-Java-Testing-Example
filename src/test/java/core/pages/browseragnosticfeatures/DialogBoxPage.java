package core.pages.browseragnosticfeatures;

import core.pages.common.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(css = ".modal-title")
    private WebElement modalTitle;

    // Modal footer buttons
    @FindBy(css = ".modal-footer .btn-secondary")
    private WebElement closeModalButton;

    @FindBy(css = ".modal-footer .btn-primary")
    private WebElement saveChangesButton;
    //



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
    private Alert waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = waitForAlert();
        // Optional: Add delay only if required
        try {
            Thread.sleep(2000); // Add a fixed 2-second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            throw new RuntimeException("Thread sleep was interrupted", e);
        }
        alert.accept();
    }

    public void cancelConfirmation() {
        Alert alert = waitForAlert();
        alert.dismiss();
    }
    public void typeIntoPromptDialog(String text) {
        // Wait for the prompt dialog to appear
        Alert alert = waitForAlert();

        // Enter text into the prompt
        alert.sendKeys(text);

        // Accept the prompt (equivalent to clicking "OK")
        alert.accept();
    }
    public String getConfirmationMessageText() {

        return confirmText.getText();
    }
    public String getPromptMessageText() {
        return promptText.getText();
    }

    public String getModalDialogTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modalTitle));
        return modalTitle.getText();
    }
}
