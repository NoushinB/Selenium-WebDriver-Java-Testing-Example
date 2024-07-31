Feature: Testing WebDriver Fundamentals

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/" page

  Scenario: Click "Navigation" Button in Section 3
    When User clicks the button with the name "Navigation" in Section 3
    Then navigate to the "Navigation Example page"

