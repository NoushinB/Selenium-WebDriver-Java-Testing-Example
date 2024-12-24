Feature: Button Functionalities
  As a user, I want to interact with various buttons on the page
  So that I can confirm their behavior and ensure they function as expected

  Scenario: Verify the alert button displays an alert with the correct message
    Given I am on the page with the buttons
    When I click the "Launch alert" button
    Then an alert should appear with the text "Hello world!"
    And I accept the alert

  Scenario: Verify the confirm button updates the message when accepted
    Given I am on the page with the buttons
    When I click the "Launch confirm" button
    And I accept the confirmation dialog
    Then the text "You chose: true" should appear in the confirmation message area

  Scenario: Verify the confirm button updates the message when canceled
    Given I am on the page with the buttons
    When I click the "Launch confirm" button
    And I cancel the confirmation dialog
    Then the text "You chose: false" should appear in the confirmation message area

  Scenario: Verify the prompt button updates the message with user input
    Given I am on the page with the buttons
    When I click the "Launch prompt" button
    And I type "Alice" into the prompt dialog
    And I confirm the prompt dialog
    Then the text "You typed: Alice" should appear in the prompt message area

  Scenario: Verify the prompt button updates the message when prompt is canceled
    Given I am on the page with the buttons
    When I click the "Launch prompt" button
    And I cancel the prompt dialog
    Then the prompt message area should remain empty or display a default state

  Scenario: Verify the modal dialog updates the message when closed
    Given I am on the page with the buttons
    When I click the "Launch modal" button
    Then the modal dialog should appear
    When I click the "Close" button in the modal
    Then the text "You chose: Close" should appear in the modal message area

  Scenario: Verify the modal dialog updates the message when changes are saved
    Given I am on the page with the buttons
    When I click the "Launch modal" button
    Then the modal dialog should appear
    When I click the "Save changes" button in the modal
    Then the text "You chose: Save changes" should appear in the modal message area
