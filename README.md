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
    - Dropdown menus (select and datalist).  
    - File uploads.  
    - Checkboxes and radio buttons.  
    - Date picker, color picker, and range slider components.  

- **Navigation Page**:  
  - Validates button interactions and dynamic content updates.  

- **Additional Scenarios**:  
  - Tests advanced UI interactions, including:  
    - Color selection using a color picker.  
    - Date selection via a date picker.  
    - Adjusting values with a range slider.  

