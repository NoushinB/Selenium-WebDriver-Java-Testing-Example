package steps;

import core.pages.HomePage;
import core.pages.webform_components.WebFormComponentsPage;
import core.pages.webform_components.WebFormTextElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class WebFormComponentsStepDefinitions {
    final private WebFormComponentsPage webFormComponentsPage;
    final private HomePage homePage;

    public WebFormComponentsStepDefinitions() {
        webFormComponentsPage = new WebFormComponentsPage();
        homePage = new HomePage();
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
        String actual = webFormComponentsPage.getTextInputValue(WebFormTextElement.TEXT_AREA);
        assertEquals(textContent, actual);
    }

    @Given("the input field is disabled")
    public void the_input_field_is_disabled() {
        assertTrue(webFormComponentsPage.isDisabledInputDisabled());
    }

    @Then("the input field displays {string}")
    public void theInputFieldDisplays(String expextDisabledInput) {
        String actualDisabledInput = webFormComponentsPage.getDisabledInputMessage();
        assertEquals(expextDisabledInput, actualDisabledInput);
    }

    @When("the input field is readonly with the value {string}")
    public void the_input_field_is_readonly_with_the_value(String expectedValue) {
        assertTrue(webFormComponentsPage.isReadonlyInputReadonly());
        assertEquals(expectedValue, webFormComponentsPage.getReadonlyInputValue());
    }


    @Then("User should not be able to write the value")
    public void user_should_not_be_able_to_remove_the_value() {
        assertTrue(webFormComponentsPage.isReadonlyInputUnchangedAfterAttempt());
    }

    @When("User clicks on the {string} button")
    public void userClicksTheButton(String buttonText) {
        if (buttonText.equals("Return to index")) {
            webFormComponentsPage.clickReturnToIndex();
        }
    }

    @Then("User should be redirected to the {string} page")
    public void user_should_be_redirected_to_the_page(String page) throws InterruptedException {
        homePage.goToUrl(page);
    }

    @When("User clicks on the dropdown menu")
    public void userClicksOnTheDropdownMenu() {
        webFormComponentsPage.clickOnDropDownButton();
    }

    @And("the user selects the option {string}")
    public void theUserSelectsThe(String optionName) {
        webFormComponentsPage.menuItemClick(optionName);
    }

    @Then("the dropdown menu shows the {string} title")
    public void theDropdownMenuItemsShouldBeVisibleForButton(String optionName) {
        assertEquals(optionName, webFormComponentsPage.getDropDownFirstSelectedOptionText());
    }

    @When("User types {string} into the datalist input field")
    public void user_types_into_the_datalist_input_field(String query) {
        webFormComponentsPage.enterTextInDatalist(query);
    }

    @Then("the datalist should display matching suggestions")
    public void the_datalist_should_display_matching_suggestions() {
        List<WebElement> suggestions = webFormComponentsPage.getSuggestions();
        assertFalse("No suggestions found", suggestions.isEmpty());
    }

    @When("User selects {string} from the datalist suggestions")
    public void user_selects_from_the_datalist_suggestions(String option) {
        webFormComponentsPage.selectDatalistOption(option);
    }

    @Then("the input field should display {string}")
    public void the_input_field_should_display(String expectedValue) {
        String actualValue = webFormComponentsPage.getDatalistInputValue();
        assertEquals(expectedValue, actualValue);
    }


    @When("User selects a file {string} located at {string}")
    public void user_selects_a_file_using_the_file_input(String filename, String filePath) {
        webFormComponentsPage.uploadFile(filePath);
    }

    @Then("the file input should display {string}")
    public void the_file_input_should_display(String filename) {
        String displayedFileName = webFormComponentsPage.getUploadedFileName();
        Assert.assertTrue("The file input did not display the expected filename", displayedFileName.contains(filename));
    }

    @When("User unchecks the checkbox")
    public void user_checks_the_checkbox() {
        webFormComponentsPage.checkedCheckboxClick();
    }

    @Then("the checkbox should be unchecked")
    public void the_checkbox_should_be_checked() {
        Assert.assertFalse(webFormComponentsPage.isCheckboxChecked());
    }

    @When("User checks the checkbox")
    public void user_unchecks_the_checkbox() {
        webFormComponentsPage.checkedCheckboxClick();
    }

    @Then("the checkbox should be checked")
    public void the_checkbox_should_be_unchecked() {
        Assert.assertTrue(webFormComponentsPage.isCheckboxChecked());
    }

    @When("User selects the {string} radio button")
    public void user_selects_the_radio_button(String string) {
        webFormComponentsPage.selectRadioButton();
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

    @When("^User chooses the color \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" from the color picker")
    public void userChoosesTheColorFromTheColorPicker(int red, int green, int blue) {
        webFormComponentsPage.selectColorByRgb(red, green, blue);
    }

    @Then("the color picker should display the color {string}")
    public void theColorPickerShouldDisplayTheColor(String expectedColor) {
        String actualColor = webFormComponentsPage.getSelectedColor();
        Assert.assertEquals(expectedColor, actualColor);
    }

    @When("User selects the date {string} from the date picker")
    public void userSelectsTheDateFromTheDatePicker(String date) {
        webFormComponentsPage.setDatePickerValue(date);
        
    }

    @Then("the date picker should display {string}")
    public void theDatePickerShouldDisplay(String expectedDate) {
        String actualDate=webFormComponentsPage.getDatePickerValue();
        Assert.assertEquals(expectedDate,actualDate);

    }

    @When("User moves the range slider to a value of {string}")
    public void userMovesTheRangeSliderToAValueOf(String arg0) {
        
    }

    @Then("the range input should display a value of {string}")
    public void theRangeInputShouldDisplayAValueOf(String arg0) {
    }
}
