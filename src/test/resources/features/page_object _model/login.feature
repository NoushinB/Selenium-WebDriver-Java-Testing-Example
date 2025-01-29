Feature: Login Functionality
  As a user, I want to log in using valid credentials
  So that I can access the secure area of the website

  Background:
    Given the user is on the "login" page

  Scenario Outline: User attempts to log in with different credentials
    When the user enters "<username>" in the username field
    And the user enters "<password>" in the password field
    And the user clicks the "Submit" button
    Then the user should see "<message>"

    Examples:
      | username | password | message                     |
      | user     | user     | Login successful           |
      | admin    | admin    | Invalid credentials        |
      | test     | pass123  | Invalid credentials        |
      |          | user     | Invalid credentials        |
      | user     |          | Invalid credentials        |
