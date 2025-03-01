package steps.browseragnosticfeatures;

import pages.browseragnosticfeatures.InfiniteScrollingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InfiniteScrollingStepDefinitions {

    private final InfiniteScrollingPage infiniteScrollingPage;

    public InfiniteScrollingStepDefinitions() {
        infiniteScrollingPage = new InfiniteScrollingPage();
    }

    @And("the Infinite scroll section is visible on the page")
    public void theSectionIsVisibleOnThePage() {
        boolean isVisible = infiniteScrollingPage.isInfiniteScrollContentVisible();
        Assert.assertTrue("The Infinite scroll content is not visible on the page.", isVisible);
    }

    @When("the user scrolls to the bottom of the visible content in the Infinite scroll section")
    public void theUserScrollsToTheBottomOfTheVisibleContentInTheSection() {
        infiniteScrollingPage.scrollToBottom();
    }

    @Then("new content is dynamically loaded")
    public void newContentIsDynamicallyLoaded() {
        boolean isContentLoaded = infiniteScrollingPage.isNewContentLoaded();
        Assert.assertTrue("New content was not dynamically loaded.", isContentLoaded);
    }

    @And("the newly loaded content is appended below the existing content")
    public void theNewlyLoadedContentIsAppendedBelowTheExistingContent() {
        int initialHeight = infiniteScrollingPage.getContentHeight();
        infiniteScrollingPage.scrollToBottom();
        int newHeight = infiniteScrollingPage.getContentHeight();

        Assert.assertTrue("The new content was not appended below the existing content.", newHeight > initialHeight);
    }

    @And("there should be no full page reload during this process")
    public void thereShouldBeNoFullPageReloadDuringThisProcess() {
        String initialUrl = infiniteScrollingPage.getCurrentPageURL();
        infiniteScrollingPage.scrollToBottom();
        String currentUrl = infiniteScrollingPage.getCurrentPageURL();

        Assert.assertEquals("A full page reload occurred during the process.", initialUrl, currentUrl);
    }
}
