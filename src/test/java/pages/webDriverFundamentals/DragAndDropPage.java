package pages.webDriverFundamentals;

import pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    private final Actions actions;
    @FindBy(id = ("draggable"))
    private WebElement draggableElement;
    @FindBy(id = ("target"))
    private WebElement targetElement;

    public DragAndDropPage() {
        actions = new Actions(driver);
    }


    public void dragAndDropElement() {
        actions.dragAndDrop(draggableElement, targetElement).build().perform();
    }

    public boolean isElementAtTarget() {
        return draggableElement.getLocation().equals(targetElement.getLocation());
    }

}
