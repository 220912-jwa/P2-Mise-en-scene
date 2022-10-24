Feature: Adding New Movies to Library
  Scenario: MIS-26 Add Movie Via IMDB ID
    Given the user is logged in and on their "Library View" page
    When the user enters "tt5108870" into the IMDB ID field
    When the user clicks the Get Movie Information button
    Then the movie's information should be input into the correct fields
    When the user checks the box for Watched
    When the user clicks the Submit button
    Then the new entry should appear on the user's Library View