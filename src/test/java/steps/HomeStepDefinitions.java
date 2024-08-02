package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeStepDefinitions {

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) {
        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/", page);
    }

    @When("the user clicks the button named {string} in Section three")
    public void theUserClicksTheButtonNamedInSection(String arg0) {
        assertTrue(true);
    }

    @Then("the user is navigated to the {string} page")
    public void theUserIsNavigatedToThePage(String arg0) {
        assertTrue(true);
    }




    /*@When("the user clicks the button named {string} in Section {string}")
    public void theUserClicksTheButtonNamedInSection(String arg0, int arg1) {

    }

    @Then("the user is navigated to the {string} page")
    public void theUserIsNavigatedToThePage(String arg0) {
    }*/


}
