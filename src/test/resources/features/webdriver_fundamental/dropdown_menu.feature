Feature: Dropdown Menu Interaction

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html" page

  Scenario Outline: User interacts with dropdown menus
    When User clicks on the "<button_name>" dropdown button
    Then the dropdown menu items should be visible
    Examples:
      | button_name |
      |my-dropdown-1|
      |my-dropdown-2|
      |my-dropdown-3|


  Scenario Outline: User selects an item in the first dropdown
    When User clicks on the "<button_name>" dropdown button
    And the dropdown menu items should be visible
    Then the user selects the "<item_name>" item in the dropdown
    Examples:
      | button_name  | item_name           |
      |my-dropdown-1| Action              |
      |my-dropdown-1| Another action      |
      |my-dropdown-2| Something else here |
      |my-dropdown-3| Separated link      |
