Feature: WebDriver Fundamentals

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/" page


  Scenario Outline: Click the button to navigate to the specific page related to that content.

    When the user clicks the button named "<button_name>" in Section 3
    Then the user is navigated to the "<target_page>" page

    Examples:
      | button_name   | target_page        |
      | Navigation    | Navigation Example |
      | Web form      | Web form           |
      | Dropdown menu | Dropdown menu      |
      | Mouse over    | Mouse over         |
