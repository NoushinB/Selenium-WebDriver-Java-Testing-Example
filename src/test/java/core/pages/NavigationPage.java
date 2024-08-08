package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class NavigationPage extends BasePage {

    @FindBy(xpath = ("//a[text()='Previous']"))
    private WebElement previousBtn;
    @FindBy(xpath = ("//a[text()='1']"))
    private WebElement btnOne;
    @FindBy(xpath = ("//a[text()='2']"))
    private WebElement btnTwo;
    @FindBy(xpath = ("//a[text()='3']"))
    private WebElement btnThree;
    @FindBy(xpath = ("//a[text()='Next']"))
    private WebElement nextBtn;

    public NavigationPage() {
    }


    public void clickOnButton(String buttonName) {

        Objects.requireNonNull(findNumbereOrStringButton(buttonName)).click();
    }

    private WebElement findNumbereOrStringButton(String buttonName) {
        switch (buttonName) {
            case "Previous":
                return previousBtn;
            case "Next":
                return nextBtn;
            case "1":
                return btnOne;
            case "2":
                return btnTwo;
            case "3":
                return btnThree;
            default:
                return null;
        }
    }

}



