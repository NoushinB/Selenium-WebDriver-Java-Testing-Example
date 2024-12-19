package steps.browseragnosticfeatures;

import core.pages.browseragnosticfeatures.InfiniteScrollingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InfiniteScrollingStepDefinitions {
    private InfiniteScrollingPage infiniteScrollingPage;

    public InfiniteScrollingStepDefinitions() {
        infiniteScrollingPage = new InfiniteScrollingPage();
    }


    @And("the {string} section is visible on the page")
    public void theSectionIsVisibleOnThePage(String sectionName) {
        boolean isVisible = infiniteScrollingPage.isSectionVisible(sectionName);
        Assert.assertTrue("The section '" + sectionName + "' is not visible on the page.", isVisible);
    }

    @When("the user scrolls to the bottom of the visible content in the {string} section")
    public void theUserScrollsToTheBottomOfTheVisibleContentInTheSection(String sectionName) {
        boolean isVisible = infiniteScrollingPage.isSectionVisible(sectionName);
        Assert.assertTrue("The section '" + sectionName + "' is not visible, so scrolling cannot be performed.", isVisible);

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
