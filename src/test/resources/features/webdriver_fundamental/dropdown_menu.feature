Feature: Dropdown Menu Interaction

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html" page

  Scenario: User interacts with dropdown menus
    When User clicks on the "{string}" dropdown button
    Then the dropdown menu items should be visible

  Scenario: User selects an item in the first dropdown
    When User clicks on the "{string}" dropdown button
    And the dropdown menu items should be visible
    And the user selects the "{string}" item in the dropdown
    Then the "{string}" item should be selected
