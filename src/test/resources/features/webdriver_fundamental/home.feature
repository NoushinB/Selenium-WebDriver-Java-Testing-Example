Feature: Home

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/" page

  Scenario Outline: Click the button to navigate to the specific page related to that content.
    When the user clicks the button named "<button_name>" in Section three
    Then the user is navigated to the "<target_page>" page

    Examples:
      | button_name   | target_page                                                       |
      | Navigation    | https://bonigarcia.dev/selenium-webdriver-java/navigation1.html   |
      | Web form      | https://bonigarcia.dev/selenium-webdriver-java/web-form.html      |
      | Dropdown menu | https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html |
      | Mouse over    | https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html    |
