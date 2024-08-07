package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public NavigationPage(){}

    public void clickPreviousBtn() {
        previousBtn.click();

    }

    public void clickButtonOne() {
        btnOne.click();
    }

    public void clickButtonTwo() {
        btnTwo.click();
    }

    public void clickButtonThree() {
        btnThree.click();
    }

    public void clickNextButton() {
        nextBtn.click();
    }
}
