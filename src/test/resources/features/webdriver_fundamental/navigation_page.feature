Feature: Navigation Page

  Background:
    Given the user is on the navigation page
    And And the "Previous" button is disabled

  Scenario: Click on a Button
    When User clicks a numbered or "Next" button
    Then the "Previous" button is enabled
    And the page content updates

  Scenario: Click on "Previous" Button
    Given the user is on a page with an enabled "Previous" button
    When the user clicks the "Previous" button
    Then the page content updates

