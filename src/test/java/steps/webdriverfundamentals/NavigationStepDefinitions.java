package steps.webdriverfundamentals;

import pages.webDriverFundamentals.NavigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class NavigationStepDefinitions {
    final private NavigationPage navigationPage;

    public NavigationStepDefinitions() {
        navigationPage = new NavigationPage();
    }

    @And("And the {string} button is disabled")
    public void andTheButtonIsDisabled(String buttonName) {
        boolean isEnabled = navigationPage.isButtonEnabled(buttonName);
        assertFalse("Button should be disabled", isEnabled);
    }

    @When("User clicks the {string} button")
    public void userClicksANumberedOrButton(String buttonName) {
        navigationPage.clickOnButton(buttonName);
    }

    @Then("the {string} button is enabled")
    public void theButtonIsEnabled(String buttonName) {
        boolean isEnabled = navigationPage.isButtonEnabled(buttonName);
        assertTrue("Button should be disabled", isEnabled);
    }

    @Then("the page content includes {string}")
    public void thePageContentUpdates(String text) {
        String fullContentText = navigationPage.getContentText();
        assertTrue(fullContentText.startsWith(text));
    }
}
