Feature: Dropdown Menu Interaction

  Background:
    Given the user is on the "dropdown-menu.html" page

  Scenario Outline: User interacts with dropdown menus
    When User clicks on the "<button_name>" dropdown button
    Then the dropdown menu items should be visible for "<button_name>"
    Examples:
      | button_name   |
      | my-dropdown-1 |
      | my-dropdown-2 |
      | my-dropdown-3 |


  Scenario Outline: User selects an item in the first dropdown
    When User clicks on the "<button_name>" dropdown button
    And the dropdown menu items should be visible for "<button_name>"
    Then the user selects the "<item_name>" item in the dropdown <dropdown_number>
    Examples:
      | button_name   | item_name           | dropdown_number |
      | my-dropdown-1 | Action              | 1               |
      | my-dropdown-1 | Another action      | 1               |
      | my-dropdown-2 | Something else here | 2               |
      | my-dropdown-3 | Separated link      | 3               |
