Feature: Web Form Components

  Background:
    Given the user is on the "https://bonigarcia.dev/selenium-webdriver-java/web-form.html" page


  # Scenario for Text Input
  Scenario Outline: Entering text into a text input field
    When User enters "<text>" into the text input field
    Then the text input field should display "<text>"

    Examples:
      | text             |
      | QA Automation         |


  # Scenario for Password
  Scenario Outline:
    When User enters "<password>" into the password field
    Then the password field should display the entered "<password>"

    Examples:
      | password        |
      | SecurePassword1 |
      | MyP@ssw0rd      |
      | Temp1234        |

  # Scenario for Textarea
  Scenario Outline: Entering text into a textarea
    When User enters "<text>" into the textarea
    Then the textarea should display content and includes "<text>"

    Examples:
      | text                           |
      | This is a multiline text input. |
      | Example of a longer text block. |
      | Short note.                     |

  # Scenario for Disabled Input
  Scenario: Attempting to enter text into a disabled input field
    And the input field is disabled
    When User tries to enter text into the disabled input field
    Then the input field should not accept any text

  # Scenario for Readonly Input
  Scenario Outline: Viewing and attempting to change a readonly input field
    And the input field is readonly with the value "<value>"
    When User attempts to change the value to "<new_value>"
    Then the input field should still display "<value>"
    And User should not be able to modify the value

    Examples:
      | value         | new_value   |
      | Readonly Value | New Value   |
      | Static Info    | Updated Info|
      | Original Text  | Changed Text|

  # Scenario for Return to Index
  Scenario: Returning to the index page
    When User clicks the "Return to index" button
    Then User should be redirected to the "https://bonigarcia.dev/selenium-webdriver-java/index.html" page

  # Scenario for Dropdown (Select)
  Scenario Outline: Selecting an option from a dropdown menu
    When User opens the dropdown menu
    And User selects "<option>" from the dropdown
    Then the dropdown should display "<option>"

    Examples:
      | option    |
      | One |
      | Two  |
      | Three  |

  # Scenario for Dropdown (Datalist)
  Scenario Outline: Searching and selecting an option from a datalist
    When User types "<query>" into the datalist input field
    Then the datalist should display matching suggestions
    When User selects "<option>" from the datalist suggestions
    Then the input field should display "<option>"

    Examples:
      | query     | option    |
      | Option 1  | San Francisco |


  # Scenario for File Input
  Scenario Outline: Uploading a file
    When User selects a file "<filename>" using the file input
    Then the file input should display "<filename>"

    Examples:
      | filename       |
      | document.pdf   |
      | image.png      |


  # Scenario for Checkbox
  Scenario: Checking and unchecking a checkbox
    When User checks the checkbox
    Then the checkbox should be checked
    When User unchecks the checkbox
    Then the checkbox should be unchecked

  # Scenario for Radio Button
  Scenario Outline: Selecting a radio button
    When User selects the "<option>" radio button
    Then the "<option>" radio button should be checked
    And other radio buttons should not be selected

    Examples:
      | option     |
      | Checked radio  |


  # Scenario for Color Picker
  Scenario Outline: Choosing a color from the color picker
    When User chooses the color "<color>" from the color picker
    Then the color picker should display the color "<color>"

    Examples:
      | color     |
      | #FF5733   |
      | #33FF57   |
      | #5733FF   |

  # Scenario for Date Picker
  Scenario Outline: Selecting a date from the date picker
    When User selects the date "<date>" from the date picker
    Then the date picker should display "<date>"

    Examples:
      | date       |
      | 2024-08-23 |
      | 2023-12-31 |
      | 2025-01-01 |

  # Scenario for Range Input
  Scenario Outline: Adjusting the range input
    When User moves the range slider to a value of "<value>"
    Then the range input should display a value of "<value>"

    Examples:
      | value |
      | 0    |

