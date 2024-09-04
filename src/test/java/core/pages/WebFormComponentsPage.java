package core.pages;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFormComponentsPage extends BasePage {

    @FindBy(id = "my-text-id")
    private WebElement textInput;
    @FindBy(xpath = "//input[@name='my-password']")
    private WebElement password;
    @FindBy(xpath = "//textarea[@name='my-textarea']")
    private WebElement textArea;
    @FindBy(xpath = "//input[@placeholder='Disabled input']")
    private WebElement disabledInput;
    @FindBy(xpath = "//input[@name='my-readonly']")
    private WebElement readonlyInput;
    @FindBy(xpath = "//a[normalize-space()='Return to index']")
    private WebElement returnToIndex;
    @FindBy(xpath = "//select[@name='my-select']")
    private WebElement dropDownSelect;
    @FindBy(xpath = "//input[@placeholder='Type to search...']")
    private WebElement dropDownDataList;
    @FindBy(xpath = "//input[@name='my-file']")
    private WebElement inputFile;
    @FindBy(id = "my-check-1")
    private WebElement checkedCheckbox;
    @FindBy(id = "my-check-2")
    private WebElement defaultCheckbox;
    @FindBy(id = "my-radio-1")
    private WebElement checkedRadio;
    @FindBy(id = "my-radio-2")
    private WebElement defaultRadio;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@name='my-colors']")
    private WebElement colorPicker;
    @FindBy(xpath = "//input[@name='my-date']")
    private WebElement datePicker;
    @FindBy(xpath = "//input[@name='my-range']")
    private WebElement rangeSlider;


    public void enterTextInput(String text) {
        textInput.clear();
        textInput.sendKeys(text);
    }
    public String getTextInputValue(){
        return textInput.getAttribute("value");
    }
    public void enterPassword(String passwordText){
        password.clear();
        password.sendKeys(passwordText);
    }
    public String getPasswordValue(){
        return password.getAttribute("Value");
    }

    public void enterTextArea(String text) {
        textArea.clear();
        textArea.sendKeys(text);
    }
    public String getTextAreaValue() {
        return textArea.getText();
    }

}
