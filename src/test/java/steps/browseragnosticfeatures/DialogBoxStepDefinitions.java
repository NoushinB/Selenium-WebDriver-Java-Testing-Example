package steps.browseragnosticfeatures;

import core.pages.browseragnosticfeatures.DialogBoxPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DialogBoxStepDefinitions {
    private final DialogBoxPage dialogBoxPage;

    public DialogBoxStepDefinitions() {
        dialogBoxPage = new DialogBoxPage();
    }

    @When("the user click the {string} button")
    public void the_user_click_the_button(String buttonName) {
        dialogBoxPage.clickOnButton(buttonName);
    }

    @Then("an alert should appear with the text {string}")
    public void an_alert_should_appear_with_the_text(String expectedText) {
        String alertText = dialogBoxPage.getAlertText();

        assertEquals(expectedText, alertText);
    }

    @Then("the user accept the alert")
    public void the_user_accept_the_alert() {
        dialogBoxPage.acceptAlert();
    }

    @When("the user accept the confirmation dialog")
    public void the_user_accept_the_confirmation_dialog() {
        dialogBoxPage.acceptAlert();
    }

    @Then("the text {string} should appear in the confirmation message area")
    public void the_text_should_appear_in_the_confirmation_message_area(String expectedText) {
        String actualText = dialogBoxPage.getConfirmationMessageText();
        assertEquals(expectedText, actualText);
    }

    @When("the user cancel the confirmation dialog")
    public void the_user_cancel_the_confirmation_dialog() {
        dialogBoxPage.cancelConfirmation();
    }

    @When("the user type {string} into the prompt dialog")
    public void the_user_type_into_the_prompt_dialog(String text) {
        dialogBoxPage.typeIntoPromptDialog(text);
    }

    @When("the user confirm the prompt dialog")
    public void the_user_confirm_the_prompt_dialog() {
        dialogBoxPage.acceptAlert();
    }

    @Then("the text {string} should appear in the prompt message area")
    public void the_text_should_appear_in_the_prompt_message_area(String expectedText) {
        String actualText = dialogBoxPage.getPromptMessageText();
        assertEquals(expectedText, actualText);
    }

    @When("the user cancel the prompt dialog")
    public void the_user_cancel_the_prompt_dialog() {
        dialogBoxPage.cancelConfirmation();
    }

    @Then("the prompt message area should remain empty or display a default state")
    public void the_prompt_message_area_should_remain_empty_or_display_a_default_state() {
        String actualText = dialogBoxPage.getPromptMessageText();

        // Define the expected default state (assuming it's an empty string or some default value like "No input")
        String defaultState = "You typed: null"; // Update this value if there's a default message in your application
assertTrue("The prompt message area is not empty or in the default state. Found: " + actualText,
        actualText.isEmpty() || actualText.equals(defaultState));


    }
    @Then("the modal dialog should appear with the title {string}")
    public void theModalDialogShouldAppearWithTheTitle(String expectedTitle) {
        String actualTitle = dialogBoxPage.getModalDialogTitle();
        assertEquals("The modal dialog title does not match the expected value.", expectedTitle, actualTitle);
    }


    @When("the user click the {string} button in the modal")
    public void the_user_click_the_button_in_the_modal(String buttonName) {
        dialogBoxPage.clickOnButton(buttonName);
    }

    @Then("the text {string} should appear in the modal message area")
    public void the_text_should_appear_in_the_modal_message_area(String expectedText) {
        String actualText = dialogBoxPage.getModalMessageText();
        assertEquals("The text in the modal message area does not match the expected value.", expectedText, actualText);
    }


}
