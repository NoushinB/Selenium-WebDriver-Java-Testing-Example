package pages.webDriverFundamentals;

import pages.common.BasePage;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class DropDownMenuPage extends BasePage {

    @FindBy(id = ("my-dropdown-1"))
    private WebElement dropDown1;
    @FindBy(id = ("my-dropdown-2"))
    private WebElement dropDown2;
    @FindBy(id = ("my-dropdown-3"))
    private WebElement dropDown3;

    @FindBy(xpath = "//ul[@class='dropdown-menu show']//a[@class='dropdown-item']")
    private List<WebElement> visibleDropDownMenus1;
    @FindBy(xpath = "//ul[@id='context-menu-2']//a[@class='dropdown-item']")
    private List<WebElement> visibleDropDownMenus2;
    @FindBy(xpath = "//ul[@id='context-menu-3']//a[@class='dropdown-item']")
    private List<WebElement> visibleDropDownMenus3;

    public void clickOnButton(String buttonName) {
        WebElement dropdownButton = findDropDownButton(buttonName);
        Objects.requireNonNull(dropdownButton, "Button not found: " + buttonName);

        Actions actions = new Actions(driver);

        switch (buttonName) {
            case "my-dropdown-1" -> dropdownButton.click();
            case "my-dropdown-2" -> actions.contextClick(dropdownButton).perform();
            case "my-dropdown-3" -> actions.doubleClick(dropdownButton).perform();
        }
    }

    public void menuItemClick(int menuNumber, String itemText) {
        WebElement item = switch (menuNumber) {
            case 1 -> findMenuItem(visibleDropDownMenus1, itemText);
            case 2 -> findMenuItem(visibleDropDownMenus2, itemText);
            case 3 -> findMenuItem(visibleDropDownMenus3, itemText);
            default -> throw new IllegalStateException("Unexpected value: " + menuNumber);
        };
        Objects.requireNonNull(item, "Menu item not found: " + itemText);
        item.click();
    }

    private WebElement findMenuItem(List<WebElement> elements, String itemText) {
        return elements.stream().filter(item -> Objects.equals(item.getText(), itemText)).findAny().orElse(null);
    }

    private WebElement findDropDownButton(String buttonName) {
        return switch (buttonName) {
            case "my-dropdown-1" -> dropDown1;
            case "my-dropdown-2" -> dropDown2;
            case "my-dropdown-3" -> dropDown3;
            default -> null;
        };
    }

    public boolean areMenuItemsVisible(String buttonName) {
        if (Objects.equals(buttonName, "my-dropdown-1")) {
            return !visibleDropDownMenus1.isEmpty();
        } else if (Objects.equals(buttonName, "my-dropdown-2")) {
            return !visibleDropDownMenus2.isEmpty();
        } else if (Objects.equals(buttonName, "my-dropdown-3")) {
            return !visibleDropDownMenus3.isEmpty();
        } else {
            throw new NotFoundException("Menu not found");
        }
    }
}
