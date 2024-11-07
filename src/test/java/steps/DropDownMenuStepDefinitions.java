package steps;

import core.pages.DropDownMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class DropDownMenuStepDefinitions {
    final private DropDownMenuPage dropDownMenuPage;

    public DropDownMenuStepDefinitions() {
        dropDownMenuPage = new DropDownMenuPage();
    }

    @When("User clicks on the {string} dropdown button")
    public void user_clicks_on_dropdown_button(String buttonName) {
        dropDownMenuPage.clickOnButton(buttonName);
    }

    @Then("the dropdown menu items should be visible for {string}")
    public void dropdown_menu_items_should_be_visible(String buttonName) {
        assertTrue(dropDownMenuPage.areMenuItemsVisible(buttonName));
    }

    @And("the user selects the {string} item in the dropdown {int}")
    public void user_selects_dropdown_item(String itemName, int dropdownNumber) {
        dropDownMenuPage.menuItemClick(dropdownNumber, itemName);
    }
}
