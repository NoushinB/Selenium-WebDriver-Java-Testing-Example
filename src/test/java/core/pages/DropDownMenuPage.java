package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
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
        Objects.requireNonNull(findDropDownButton(buttonName)).click();
    }

    private WebElement findDropDownButton(String buttonName) {
        switch (buttonName) {
            case "my-dropdown-1":
                return dropDown1;
            case "my-dropdown-2":
                return dropDown2;
            case "my-dropdown-3":
                return dropDown3;
            default:
                return null;
        }
    }
}
