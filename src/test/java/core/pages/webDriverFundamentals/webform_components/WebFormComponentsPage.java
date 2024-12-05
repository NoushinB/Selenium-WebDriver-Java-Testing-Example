package core.pages.webDriverFundamentals.webform_components;

import core.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
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
    @FindBy(xpath = "//input[@class='form-control' and @name='my-datalist' and @list='my-options']")
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

    public void clickReturnToIndex() {
        returnToIndex.click();
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

    public void clickOnDropDownButton() {
        dropDownSelect.click();
    }

    public void menuItemClick(String itemText) {
        Select select = new Select(dropDownSelect);
        select.selectByVisibleText(itemText);
    }

    public String getDropDownFirstSelectedOptionText() {
        Select select = new Select(dropDownSelect);
        return select.getFirstSelectedOption().getText();
    }

    public void enterTextInDatalist(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dropDownDataList));  // Wait for the input field to be visible
        dropDownDataList.clear();
        dropDownDataList.sendKeys(query);
    }

    public List<WebElement> getSuggestions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datalist[@id='my-options']")));

        // Get all the options inside the datalist
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//datalist[@id='my-options']/option")));

        // Debugging: print number of options
        System.out.println("Number of options found: " + options.size());

        return options;
    }

    public void selectDatalistOption(String option) {
        enterTextInDatalist(option);  // Type text to filter options
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datalist[@id='my-options']/option[@value='" + option + "']")));
        dropDownDataList.sendKeys(Keys.ARROW_DOWN);  // Navigate to the first suggestion
        dropDownDataList.click();       // Select the highlighted suggestion
    }

    public String getDatalistInputValue() {
        return dropDownDataList.getAttribute("value");
    }

    public void uploadFile(String filePath) {
        String absolutePath = Paths.get(filePath).toAbsolutePath().toString();
        inputFile.sendKeys(absolutePath);
    }

    public String getUploadedFileName() {
        return inputFile.getAttribute("value");
    }


    public void checkedCheckboxClick() {
        checkedCheckbox.click();
    }

    public boolean isCheckboxChecked() {
        return checkedCheckbox.isSelected();
    }

    public void selectRadioButton() {
        checkedRadio.click();
    }

    public boolean isRadioButtonSelected() {
        return checkedRadio.isSelected();
    }

    public void selectDefaultRadio() {
        defaultRadio.click();
    }

    public void selectColorByRgb(int red, int green, int blue) {
        Objects.requireNonNull(colorPicker, "Color picker element not found.");
        String color = rgbToHex(red, green, blue);
        colorPicker.clear();
        colorPicker.sendKeys(color);
    }

    /**
     * Method to get the current value of the color picker
     * @return color picker selected value
     */
    public String getSelectedColor() {
        Objects.requireNonNull(colorPicker, "Color picker element not found.");
        return colorPicker.getAttribute("value");
    }

    /**
     * Utility method to convert RGB to Hex
     */
    public String rgbToHex(int red, int green, int blue) {
        return String.format("#%02x%02x%02x", red, green, blue);
    }

    /**
     * Sets a specific date in the date picker input.
     *
     * @param date The date to set in the format YYYY-MM-DD.
     */
    public void setDatePickerValue(String date) {
        Objects.requireNonNull(date, "Date cannot be null.");
        datePicker.clear(); // Clear any existing value in the date picker
        datePicker.sendKeys(date); // Input the desired date
        datePicker.sendKeys(Keys.TAB); // Tab out to trigger any event listeners
    }
    /**
     * Retrieves the current value displayed in the date picker input.
     *
     * @return The value of the date picker input.
     */
    public String getDatePickerValue() {
        return datePicker.getAttribute("value");
    }
    /**
     * Adjust the range slider to a specific value.
     *
     * @param value The target value to set for the slider.
     */
    public void adjustRangeSliderTo(int value) {
        int currentValue = Integer.parseInt(rangeSlider.getAttribute("value"));
        int offset = value - currentValue;

        // Simulate range slider adjustment using keyboard actions
        for (int i = 0; i < Math.abs(offset); i++) {
            if (offset > 0) {
                rangeSlider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                rangeSlider.sendKeys(Keys.ARROW_LEFT);
            }
        }
    }

    /**
     * Retrieve the current value of the range slider.
     *
     * @return The current value of the slider as a String.
     */
    public String getRangeSliderValue() {
        return rangeSlider.getAttribute("value");
    }



}
