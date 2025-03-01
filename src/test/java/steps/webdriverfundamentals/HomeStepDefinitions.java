package steps.webdriverfundamentals;

import core.library.PropertyLoader;
import pages.webDriverFundamentals.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class HomeStepDefinitions {
    final private HomePage homePage;

    public HomeStepDefinitions() {
        homePage = new HomePage();
    }

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() throws InterruptedException {
        String url = PropertyLoader.getInstance().getBaseUrl();
        homePage.goToUrl(url);
    }

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) throws InterruptedException {
        String url = PropertyLoader.getInstance().getBaseUrl() + page;
        homePage.goToUrl(url);
    }

    @When("the user clicks the button named {string} in Section three")
    public void theUserClicksTheButtonNamedInSection(String buttonName) {
        homePage.clickOnButton(buttonName);
    }

    @Then("the user is navigated to the {string} page")
    public void theUserIsNavigatedToThePage(String page) {
        String expectedUrl = PropertyLoader.getInstance().getBaseUrl() + page;
        String currentUrl = homePage.getCurrentPageURL();
        assertEquals(expectedUrl, currentUrl);
    }
}
