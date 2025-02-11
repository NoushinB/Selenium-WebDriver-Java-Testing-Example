# Selenium WebDriver Java Testing Example

This repository provides an example of using **Selenium WebDriver** with **Java**, **JUnit**, **Cucumber**, and **Gherkin** for browser automation and UI testing. It includes a simple framework for managing WebDriver instances, reusable UI methods, page objects, and example tests that interact with a web form on [Boni García's Selenium WebDriver page](https://bonigarcia.dev/selenium-webdriver-java/web-form.html).

The tests are written using the **Cucumber** framework in **Gherkin** syntax, which allows for behavior-driven development (BDD) style scenarios. **JUnit** is used as the test runner to execute the feature files.


## Overview

This project demonstrates how to build a basic Selenium WebDriver testing framework in Java. The repository contains:

- **Driver management** with thread-safe WebDriver instances.
- **Reusable UI methods** and **page objects** for interacting with web elements.
- **Sample test scenarios** that cover various web components (text input, password fields, checkboxes, dropdowns, etc.).
- **Cucumber-based feature files** for defining test scenarios in a behavior-driven development (BDD) style.

## Cucumber-Based Feature Files  

This repository includes comprehensive Cucumber feature files written in Gherkin syntax. These files define test scenarios for behavior-driven development (BDD) and cover a wide range of functionalities:  

- **Infinite Scroll**:  
  - Validates dynamic content loading as the user scrolls to the bottom of the page.  
  - Ensures new content is appended without triggering a full-page reload.  

- **Drag and Drop**:  
  - Tests drag-and-drop functionality, verifying that elements are repositioned correctly.  

- **Dropdown Menu Interaction**:  
  - Scenarios for interacting with dropdown buttons and verifying menu item visibility and selection.  

- **Home Page Navigation**:  
  - Tests navigation to various pages using specific buttons on the home page.  

- **Web Form Components**:  
  - Covers interaction with various form elements, including:  
    - Text inputs and password fields.  
    - Dropdown menus (select and data list).  
    - File uploads.  
    - Checkboxes and radio buttons.  
    - Date picker, color picker, and range slider components.  

- **Navigation Page**:  
  - Validates button interactions and dynamic content updates.  

- **Login Functionality**:  
  - Validates user authentication by testing login attempts with valid and invalid credentials.  
  - Ensures appropriate success or error messages are displayed based on login attempts.  

- **Button Functionalities**:  
  - Verifies interactions with alert, confirm, and prompt dialogs.  
  - Ensures correct messages are displayed when accepting, canceling, or inputting text in prompt dialogs.  
  - Tests modal dialogs for expected behavior when closed or when changes are saved.
 
 
## Class Structure:

### `core.drivers`

- **`DriverManager`**
  - Manages web driver instances for multiple threads.
  - Likely includes methods for creating, getting, and removing WebDriver instances in a thread-safe manner.

- **`DriverProvider`**
  - Provides the necessary WebDriver instances (like Chrome or Firefox).
  - Handles configurations like ChromeOptions for setting up the driver (i.e., headless mode, browser-specific properties, etc.).
  - Likely manages different browsers and timeout configurations.

---

### `core.library`

- **`Constants`**
  - Contains static final variables used throughout the test, such as timeouts, URL constants, browser names, etc.

- **`PropertyLoader`**
  - A Singleton class designed to load configuration properties (i.e., from `.properties` files) and ensure that only one instance of the class is used throughout the tests.
  - Ensures centralized and controlled access to configuration values.

---

### `core.pages.browseragnosticfeatures`

- **`DialogBoxPage`**
  - A Page Object that deals with browser-agnostic features like dialog boxes.
  - Contains logic for interacting with alerts and dialog elements (using `Alert` and `WebDriverWait`).

- **`InfiniteScrollingPage`**
  - A Page Object handling infinite scroll features in the web application.
  - Contains interactions and waits that are unique to infinite scrolling scenarios.

---

### `core.pages.common`

- **`BasePage`**
  - The base class for all pages that could have common elements or actions that every page shares.
  - Most likely, this class contains a constructor for page factory initialization (with `PageFactory.initElements(driver, this)`).
  - Also includes driver and WebDriver-specific methods.

---

### `core.pages.pageobjectmodel`

- **`LoginFormPage`**
  - A Page Object model for login form interactions (like entering credentials, clicking login buttons, etc.).
  - Contains specific methods for interacting with the login form.

---

### `core.pages.webDriverFundamentals.webform_components`

- **`WebFormComponentsPage`**
  - A Page Object for handling form components such as text fields, checkboxes, dropdowns, etc.
  - Includes elements like `WebFormTextElement` to distinguish different types of form inputs.

- **`WebFormTextElement` (Enum)**
  - An enumeration that identifies different types of text-based form fields like `PASSWORD`, `TEXT`, and `TEXT_AREA`.

---

### `core.pages.webDriverFundamentals`

- **`DragAndDropPage`**
  - A Page Object dedicated to drag-and-drop interactions.
  - Contains logic to simulate drag-and-drop events using WebDriver.

- **`DropDownMenuPage`**
  - A Page Object for interacting with dropdown menus in the web application.
  - Includes methods for selecting items from dropdowns and checking the current selection.

- **`HomePage`**
  - A Page Object for the main or home page of the web application.
  - Contains methods for interacting with elements on the home page.

- **`NavigationPage`**
  - A Page Object for handling navigation-related elements or interactions on the site (like menus or sidebars).

---

### `hooks`

- **`Hooks`**
  - A Cucumber hook class that initializes or terminates the test execution.
  - Contains methods annotated with `@Before` and `@After` to set up or tear down things like WebDriver instances before and after the tests.

---

### `steps.browseragnosticfeatures`

- **`DialogBoxStepDefinitions`**
  - Step definition class that defines the steps for handling dialog boxes in tests.
  - Steps might include clicking buttons on the dialog, verifying alert messages, etc.

- **`InfiniteScrollingStepDefinitions`**
  - Step definition class that defines steps for interacting with infinite scrolling pages, such as scrolling until an element is visible.

---

### `steps.pageobjectmodel`

- **`LoginFormStepDefinitions`**
  - Step definition class with steps to interact with the login form (filling out username/password fields and submitting the form).

---

### `steps.webdriverfundamentals`

- **`DragAndDropStepDefinitions`**
  - Step definition class for defining actions related to drag-and-drop functionality.
   
- **`DropDownMenuStepDefinitions`**
  - Step definition class that includes steps for interacting with dropdown menus in the tests.

- **`HomeStepDefinitions`**
  - Step definition class for testing interactions on the home page.
   
- **`NavigationStepDefinitions`**
  - Step definition class for interactions related to navigation elements.

- **`WebFormComponentsStepDefinitions`**
  - Step definition class for interacting with web form components like input fields, buttons, and dropdowns.

---

### `RunCucumberTest`
- The test runner class that uses Cucumber to run the tests.
- Defines the location of feature files and configures reporting options for the test execution.


  ## Test Reports

After running the tests, you can find the test execution reports in the `target` directory. The reports are generated in HTML format, providing a detailed overview of the test results.

![Test Report ](https://github.com/NoushinB/Selenium-WebDriver-Java-Testing-Example/blob/master/src/test/resources/files/report.png) 

---

## Test Execution Demo
    

[![Watch the RestAssured-API-Testing DEMO](https://github.com/NoushinB/Selenium-WebDriver-Java-Testing-Example/blob/master/src/test/resources/files/report.png?raw=true)](https://youtu.be/USy0EVfLg2s)


