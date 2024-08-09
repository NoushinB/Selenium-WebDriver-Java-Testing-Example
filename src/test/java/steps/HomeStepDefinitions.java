package steps;

import core.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeStepDefinitions {
    final private HomePage homePage;

    public HomeStepDefinitions() {
        homePage = new HomePage();
    }

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) {
        homePage.goToUrl(page);
    }

    @When("the user clicks the button named {string} in Section three")
    public void theUserClicksTheButtonNamedInSection(String buttonName) {
        homePage.clickOnButton(buttonName);
    }

    @Then("the user is navigated to the {string} page")
    public void theUserIsNavigatedToThePage(String url) {
        String currentUrl = homePage.getCurrentPageURL();
        assertEquals(url, currentUrl);
    }

    /*@When("the user clicks the button named {string} in Section {string}")
    public void theUserClicksTheButtonNamedInSection(String arg0, int arg1) {

    }

    @Then("the user is navigated to the {string} page")
    public void theUserIsNavigatedToThePage(String arg0) {
    }*/


}
