package steps.browseragnosticfeatures;

import core.pages.browseragnosticfeatures.DialogBoxPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

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
    public void the_text_should_appear_in_the_prompt_message_area(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user cancel the prompt dialog")
    public void the_user_cancel_the_prompt_dialog() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the prompt message area should remain empty or display a default state")
    public void the_prompt_message_area_should_remain_empty_or_display_a_default_state() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the modal dialog should appear")
    public void the_modal_dialog_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user click the {string} button in the modal")
    public void the_user_click_the_button_in_the_modal(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the text {string} should appear in the modal message area")
    public void the_text_should_appear_in_the_modal_message_area(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
