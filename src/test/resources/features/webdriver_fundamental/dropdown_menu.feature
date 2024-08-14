Feature: Dropdown Menu Interaction

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html" page

  Scenario Outline: User interacts with dropdown menus
    When User clicks on the "<button_name>" dropdown button
    Then the dropdown menu items should be visible
    Examples:
      | button_name         |
      | left click         |
      |  right click        |
      |  right click        |



  Scenario Outline: User selects an item in the first dropdown
    When User clicks on the "<button_name>" dropdown button
    And the dropdown menu items should be visible
    Then the user selects the "<item_name>" item in the dropdown
    Examples:
      | button_name | item_name |
      |         left click    | Action              |
      |        right click      |      Another action      |
      |        right click      | Something else here |
      |             double click| Separated link      |
