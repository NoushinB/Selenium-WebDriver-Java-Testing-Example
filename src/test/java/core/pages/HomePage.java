package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //Chapter 3. WebDriver Fundamentals
    @FindBy(xpath = ("//a[text()='Navigation']"))
    private WebElement navigationBtn;
    @FindBy(xpath = ("//a[text()='Web form']"))
    private WebElement webFormBtn;
    @FindBy(xpath = ("//a[text()='Dropdown menu']"))
    private WebElement dropdownMenuBtn;
    @FindBy(xpath = ("//a[text()='Mouse over']"))
    private WebElement mouseOverBtn;
    @FindBy(xpath = ("//a[text()='Drag and drop']"))
    private WebElement dragAndDropBtn;
    @FindBy(xpath = ("//a[text()='Draw in canvas']"))
    private WebElement drawInCanvasBtn;
    @FindBy(xpath = ("//a[text()='Loading images']"))
    private WebElement loadingImagesBtn;
    @FindBy(xpath = ("//a[text()='Slow calculator']"))
    private WebElement slowCalculatorBtn;


    //Chapter 4. Browser-Agnostic Features
    @FindBy(xpath = ("//a[text()='Long page']"))
    private WebElement longPageBtn;
    @FindBy(xpath = ("//a[text()='Infinite scroll']"))
    private WebElement infiniteScrollBtn;
    @FindBy(xpath = ("//a[text()='Shadow DOM']"))
    private WebElement shadowDOMBtn;
    @FindBy(xpath = ("//a[text()='Frames']"))
    private WebElement framesBtn;
    @FindBy(xpath = ("//a[text()='IFrames']"))
    private WebElement iFramesBtn;
    @FindBy(xpath = ("//a[text()='Dialog boxes']"))
    private WebElement dialogBoxesBtn;
    @FindBy(xpath = ("//a[text()='Web storage']"))
    private WebElement webStorageBtn;


    //Chapter 5. Browser-Specific Manipulation
    @FindBy(xpath = ("//a[text()='Geolocation']"))
    private WebElement geolocationBtn;
    @FindBy(xpath = ("//a[text()='Notifications']"))
    private WebElement notificationsBtn;
    @FindBy(xpath = ("//a[text()='Get user media']"))
    private WebElement getUserMediaBtn;
    @FindBy(xpath = ("//a[text()='Multilanguage']"))
    private WebElement MultilanguageBtn;
    @FindBy(xpath = ("//a[text()='Console logs']"))
    private WebElement consoleLogsBtn;


    //Chapter 7. The Page Object Model (POM)
    @FindBy(xpath = ("//a[text()='Login form']"))
    private WebElement loginFormBtn;
    @FindBy(xpath = ("//a[text()='Slow login']"))
    private WebElement slowLoginBtn;


    //Chapter 8. Testing Framework SpecificsChapter 8
    @FindBy(xpath = ("//a[text()='Random calculator']"))
    private WebElement randomCalculatorBtn;


    //Chapter 9. Third-Party Integrations
    @FindBy(xpath = ("//a[text()='Download files']"))
    private WebElement downloadFilesBtn;
    @FindBy(xpath = ("//a[text()='A/B Testing']"))
    private WebElement ABTestingBtn;
    @FindBy(xpath = ("//a[text()='Data types']"))
    private WebElement dataTypesBtn;


}
