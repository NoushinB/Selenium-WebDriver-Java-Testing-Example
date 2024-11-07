Feature: Home

  Background:
    Given the user is on the main page

  Scenario Outline: Click the button to navigate to the specific page related to that content.
    When the user clicks the button named "<button_name>" in Section three
    Then the user is navigated to the "<target_page>" page

    Examples:
      | button_name   | target_page                                                       |
      | Navigation    | navigation1.html   |
      | Web form      | web-form.html      |
      | Dropdown menu | dropdown-menu.html |
      | Mouse over    | mouse-over.html    |
