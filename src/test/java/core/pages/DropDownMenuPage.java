package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class DropDownMenuPage extends BasePage {

    @FindBy(id = ("my-dropdown-1"))
    private WebElement dropDown1;
    @FindBy(id = ("my-dropdown-2"))
    private WebElement dropDown2;
    @FindBy(id = ("my-dropdown-3"))
    private WebElement dropDown3;

    public void clickOnButton(String buttonName) {
        WebElement dropdownButton = findDropDownButton(buttonName);
        Objects.requireNonNull(dropdownButton, "Button not found: " + buttonName);

        Actions actions = new Actions(driver);

        switch (buttonName) {
            case "my-dropdown-1" -> dropdownButton.click();
            case "my-dropdown-2" -> actions.doubleClick(dropdownButton).perform();
            case "my-dropdown-3" -> actions.contextClick(dropdownButton).perform();
        }
    }

    private WebElement findDropDownButton(String buttonName) {
        return switch (buttonName) {
            case "my-dropdown-1" -> dropDown1;
            case "my-dropdown-2" -> dropDown2;
            case "my-dropdown-3" -> dropDown3;
            default -> null;
        };
    }
}
