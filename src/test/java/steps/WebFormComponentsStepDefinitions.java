package steps;

import core.pages.webform_components.WebFormComponentsPage;
import core.pages.webform_components.WebFormTextElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class WebFormComponentsStepDefinitions {
    final private WebFormComponentsPage webFormComponentsPage;

    public WebFormComponentsStepDefinitions() {
        webFormComponentsPage = new WebFormComponentsPage();
    }

    @Given("the user is on the webForm page")
    public void user_is_on_the_page() {
        String webFormPage = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        String currentUrl = webFormComponentsPage.getCurrentPageURL();
        assertEquals(webFormPage, currentUrl);
    }

    @When("User enters {string} into the text input field")
    public void user_enters_into_the_text_input_field(String text) {
        webFormComponentsPage.enterTextInput(WebFormTextElement.TEXT, text);
    }

    @Then("the text input field should display {string}")
    public void the_text_input_field_should_display(String expectedText) {
        String actual = webFormComponentsPage.getTextInputValue(WebFormTextElement.TEXT);
        assertEquals(expectedText, actual);
    }

    @When("User enters {string} into the password field")
    public void user_enters_into_the_password_field(String password) {
        webFormComponentsPage.enterTextInput(WebFormTextElement.PASSWORD, password);
    }

    @Then("the password field should display the entered {string}")
    public void the_password_field_should_display_an_obscured_format_of_the_entered_password(String password) {
        String passwordValue = webFormComponentsPage.getTextInputValue(WebFormTextElement.PASSWORD);
        assertEquals(password, passwordValue);

    }

    @When("User enters {string} into the textarea")
    public void user_enters_into_the_textarea(String text) {
        webFormComponentsPage.enterTextInput(WebFormTextElement.TEXT_AREA, text);
    }

    @Then("the textarea should display content and includes {string}")
    public void the_textarea_should_display(String textContent) {
        String actual =  webFormComponentsPage.getTextInputValue(WebFormTextElement.TEXT_AREA);
        assertEquals(textContent,actual);
    }

    @Given("the input field is disabled")
    public void the_input_field_is_disabled() {
        assertTrue(webFormComponentsPage.isDisabledInputDisabled());
    }
    @Then("the input field displays {string}")
    public void theInputFieldDisplays(String expextDisabledInput) {
        String actualDisabledInput= webFormComponentsPage.getDisabledInputMessage();
        assertEquals(expextDisabledInput,actualDisabledInput);
    }





    @When("the input field is readonly with the value {string}")
    public void the_input_field_is_readonly_with_the_value(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("User should not be able to remove the value")
    public void user_should_not_be_able_to_remove_the_value() {

    }

    @Then("User should be redirected to the {string} page")
    public void user_should_be_redirected_to_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User opens the dropdown menu")
    public void user_opens_the_dropdown_menu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the dropdown should display {string}")
    public void the_dropdown_should_display(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User types {string} into the datalist input field")
    public void user_types_into_the_datalist_input_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the datalist should display matching suggestions")
    public void the_datalist_should_display_matching_suggestions() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User selects {string} from the datalist suggestions")
    public void user_selects_from_the_datalist_suggestions(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the input field should display {string}")
    public void the_input_field_should_display(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User selects a file {string} using the file input")
    public void user_selects_a_file_using_the_file_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the file input should display {string}")
    public void the_file_input_should_display(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User checks the checkbox")
    public void user_checks_the_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the checkbox should be checked")
    public void the_checkbox_should_be_checked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User unchecks the checkbox")
    public void user_unchecks_the_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the checkbox should be unchecked")
    public void the_checkbox_should_be_unchecked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User selects the {string} radio button")
    public void user_selects_the_radio_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the {string} radio button should be checked")
    public void the_radio_button_should_be_checked(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("other radio buttons should not be selected")
    public void other_radio_buttons_should_not_be_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User chooses the color {string} from the color picker")
    public void user_chooses_the_color_from_the_color_picker(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the color picker should display the color {string}")
    public void the_color_picker_should_display_the_color(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User selects the date {string} from the date picker")
    public void user_selects_the_date_from_the_date_picker(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the date picker should display {string}")
    public void the_date_picker_should_display(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User moves the range slider to a value of {string}")
    public void user_moves_the_range_slider_to_a_value_of(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the range input should display a value of {string}")
    public void the_range_input_should_display_a_value_of(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
