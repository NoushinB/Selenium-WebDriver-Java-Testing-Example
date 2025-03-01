package steps.webdriverfundamentals;

import pages.webDriverFundamentals.DragAndDropPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class DragAndDropStepDefinitions {
    final private DragAndDropPage dragAndDropPage;

    public DragAndDropStepDefinitions() {
        dragAndDropPage = new DragAndDropPage();
    }

    @Given("the user is on the DragAndDrop page")
    public void userIsOnTheDragAndDropPage() {
        String dropDownMenu = "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html";
        String currentUrl = dragAndDropPage.getCurrentPageURL();
        assertEquals(dropDownMenu, currentUrl);
    }

    @When("User drags the draggable element to the target element")
    public void user_drags_the_draggable_element_to_the_target_element() {
        dragAndDropPage.dragAndDropElement();
    }

    @Then("Draggable element should be at the same location as the target element")
    public void draggable_element_should_be_at_the_same_location_as_the_target_element() {
        dragAndDropPage.isElementAtTarget();
    }
}
