Feature: Infinite Scroll Functionality

  Background:
    Given the user is on the "infinite-scroll.html" page

  Scenario: Verify new content loads dynamically on infinite scroll

    And the Infinite scroll section is visible on the page
    When the user scrolls to the bottom of the visible content in the Infinite scroll section
    Then new content is dynamically loaded
    And the newly loaded content is appended below the existing content
    And there should be no full page reload during this process