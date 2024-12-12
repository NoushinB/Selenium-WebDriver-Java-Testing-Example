package steps.browseragnosticfeatures;

import core.pages.browseragnosticfeatures.InfiniteScrollingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InfiniteScrollingStepDefinitions {
    private final InfiniteScrollingPage infiniteScrollingPage;

    public InfiniteScrollingStepDefinitions() {
        infiniteScrollingPage = new  InfiniteScrollingPage();
    }

    @And("the {string} section is visible on the page")
    public void theSectionIsVisibleOnThePage(String arg0) {
    }

    @When("the user scrolls to the bottom of the visible content in the {string} section")
    public void theUserScrollsToTheBottomOfTheVisibleContentInTheSection(String arg0) {
    }

    @Then("new content is dynamically loaded")
    public void newContentIsDynamicallyLoaded() {
    }

    @And("the newly loaded content is appended below the existing content")
    public void theNewlyLoadedContentIsAppendedBelowTheExistingContent() {
    }

    @And("there should be no full page reload during this process")
    public void thereShouldBeNoFullPageReloadDuringThisProcess() {
    }

}
