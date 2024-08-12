Feature: Navigation Page

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/navigation1.html" page

  Scenario Outline: Click on a Button
    When User clicks the "<button_name>" button
    Then the "Previous" button is enabled
    And the page content updates

    Examples:
      | button_name   |
      | 1    |
      | 2    |
      | 3 |
      | Next    |



Scenario Outline: The page content updates
    When User clicks the "<button_name>" button
    Then the page content updates

    Examples:
      | button_name   |
      | 1    |
      | 2    |
      | 3 |
      | Next    |



