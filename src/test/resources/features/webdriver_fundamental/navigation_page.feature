Feature: Navigation Page

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/" page

  Scenario: Click on a Button
    When User clicks a numbered or "Next" button
    Then the "Previous" button is enabled
    And the page content updates

  Scenario: Click on "Previous" Button
    When User clicks a numbered or "Previous" button
    Then the page content updates

