package core.pages.webform_components;

import core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

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

    public void enterTextInput(WebFormTextElement element, String text) {
        WebElement textElement = getTextElement(element);
        Objects.requireNonNull(textElement, "Text element not found: " + element.name());
        textElement.clear();
        textElement.sendKeys(text);
    }

    public String getTextInputValue(WebFormTextElement element) {
        WebElement textElement = getTextElement(element);
        Objects.requireNonNull(textElement, "Text element not found: " + element.name());
        return textElement.getAttribute("value");
    }
    public boolean isDisabledInputDisabled() {
        return !disabledInput.isEnabled();
    }
    public String getDisabledInputMessage() {
        return disabledInput.getAttribute("placeholder");
    }
    public String getReadonlyInputValue() {
        return readonlyInput.getAttribute("value");
    }
    public boolean isReadonlyInputReadonly() {
        return readonlyInput.getAttribute("readonly") != null;
    }

    // Attempt to change the value of the readonly input field and verify it remains unchanged
    public boolean isReadonlyInputUnchangedAfterAttempt() {
        String initialValue = getReadonlyInputValue();

        // Attempt to modify the field (this will not actually change the value)
        readonlyInput.sendKeys("New Value");

        // Verify that the value remains the same
        return initialValue.equals(getReadonlyInputValue());
    }

    private WebElement getTextElement(WebFormTextElement element) {
        if (element == WebFormTextElement.TEXT) {
            return textInput;
        } else if (element == WebFormTextElement.TEXT_AREA) {
            return textArea;
        } else if (element == WebFormTextElement.PASSWORD) {
            return password;
        }
        return null;
    }
}
