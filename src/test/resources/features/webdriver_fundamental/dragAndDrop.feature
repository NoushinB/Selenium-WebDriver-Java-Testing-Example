Feature: DragAndDrop Page

  Background:
    Given the user is on the "drag-and-drop.html" page

    Scenario: Verify Drag and Drop to Target
      When User drags the draggable element to the target element
      Then Draggable element should be at the same location as the target element