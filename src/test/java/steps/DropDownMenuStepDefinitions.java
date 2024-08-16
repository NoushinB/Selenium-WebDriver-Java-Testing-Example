package steps;

import core.pages.DropDownMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DropDownMenuStepDefinitions {
    final private DropDownMenuPage dropDownMenuPage;

    public DropDownMenuStepDefinitions() {
        dropDownMenuPage = new DropDownMenuPage();
    }

    @Given("the user is on the dropDownMenu page")
    public void userIsOnTheDropDownMenuPage() {
        String dropDownMenu="https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html";
        String currentUrl=dropDownMenuPage.getCurrentPageURL();
        assertEquals(dropDownMenu,currentUrl);
    }

    @When("User clicks on the {string} dropdown button")
    public void user_clicks_on_dropdown_button(String buttonName) {
    dropDownMenuPage.clickOnButton(buttonName);
    }

    @Then("the dropdown menu items should be visible for {string}")
    public void dropdown_menu_items_should_be_visible(String buttonName) {
        assertTrue(dropDownMenuPage.areMenuItemsVisible(buttonName));
    }

    @And("the user selects the {string} item in the dropdown")
    public void user_selects_dropdown_item(String itemName) {
        // Implement code to select the specified item
        // Example: selectDropdownItem(itemName);
    }

    @Then("the {string} item should be selected")
    public void theItemShouldBeSelected(String arg0) {
    }
}
