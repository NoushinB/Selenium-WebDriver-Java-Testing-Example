package pages.pageobjectmodel;

import pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormPage extends BasePage {

    // Finding the username input field by its ID
    @FindBy(id = "username")
    private WebElement usernameInput;

    // Finding the password input field by its ID
    @FindBy(id = "password")
    private WebElement passwordInput;

    // Finding the submit button by its tag and class
    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'btn-outline-primary')]")
    private WebElement submitButton;

    // Finding the invalid credentials alert by its ID
    @FindBy(id = "invalid")
    private WebElement invalidCredentialsAlert;

    // Finding the success message alert by its ID
    @FindBy(id = "success")
    private WebElement successMessageAlert;


    /**
     * Method to enter username.
     *
     * @param username - username that enter into the input field.
     */
    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /**
     * Method to enter password.
     *
     * @param password - password that enter the input field.
     */
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String getLoginMessage() {
        if (isElementDisplayed(successMessageAlert)) {
            return successMessageAlert.getText();
        } else if (isElementDisplayed(invalidCredentialsAlert)) {
            return invalidCredentialsAlert.getText();
        }
        return "No message displayed";
    }

    private boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Handle cases where the element is not found or not visible
        }
    }


}
