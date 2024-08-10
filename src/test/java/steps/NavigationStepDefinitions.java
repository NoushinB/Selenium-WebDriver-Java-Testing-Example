package steps;

import core.pages.NavigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class NavigationStepDefinitions {
    final private NavigationPage navigationPage;

    public NavigationStepDefinitions() {
        navigationPage = new NavigationPage();
    }


    @Given("the user is on the navigation page")
    public void theUserIsOnTheNavigationPage() {

        String navigation = "https://bonigarcia.dev/selenium-webdriver-java/navigation1.html";
        // Here we can verify if the user is actually on the correct page
        String currentUrl = navigationPage.getCurrentPageURL();
        assertEquals(navigation, currentUrl);

    }


    @And("And the {string} button is disabled")
    public void andTheButtonIsDisabled(String buttonName) {
        boolean isEnabled = navigationPage.isButtonEnabled(buttonName);
        assertFalse("Button should be disabled", isEnabled);


    }

    @When("User clicks a numbered or {string} button")
    public void userClicksANumberedOrButton(String buttonName) {
        navigationPage.clickOnButton(buttonName);

    }

    @Then("the {string} button is enabled")
    public void theButtonIsEnabled(String buttonName) {
        boolean isEnabled = navigationPage.isButtonEnabled(buttonName);
        assertTrue("Button should be disabled", isEnabled);

    }

    @And("the page content updates")
    public void thePageContentUpdates() {

    }

}
