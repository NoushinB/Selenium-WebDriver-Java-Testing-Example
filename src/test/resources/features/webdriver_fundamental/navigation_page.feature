Feature: Navigation Page

  Background:
    Given the user is on the "navigation1.html" page

  Scenario Outline: Click on a Button
    When User clicks the "<button_name>" button
    Then the "Previous" button is enabled

    Examples:
      | button_name |
      | 1           |
      | 2           |
      | 3           |
      | Next        |


  Scenario Outline: The page content updates
    When User clicks the "<button_name>" button
    Then the page content includes "<text>"

    Examples:
      | button_name | text      |
      | 1           | Lorem     |
      | 2           | Ut        |
      | 3           | Excepteur |




