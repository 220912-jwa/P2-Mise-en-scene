Feature: Manual Movie Entry
  Scenario: MIS-23 Manual Entry Positive
    Given the user is logged in and on their "Library View" page
    When the user clicks "Manual Entry"
    When the user enters "Morbius" into the Title field
    When the user enters "2022" into the Year field
    When the user enters "English" into the Language field
    When the user checks the box for Watched
    When the user enters "100" into the User Rating field
    When the user checks the box for Favorite
    When the user enters "I couldn't believe my eyes when he said 'it's morbin time'" into the User Notes box
    When the user clicks the Submit button
    Then the new entry should appear on the user's Library View

  Scenario: Manual Entry Negative
    Given the user is logged in and on their "Library View" page
    When the user clicks "Manual Entry"
    When the user enters "mObiurs" into the Title field
    When the user clicks the Submit button
    Then an alert should appear prompting the user to input more information


