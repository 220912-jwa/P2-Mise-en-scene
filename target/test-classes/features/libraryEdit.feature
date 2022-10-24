Feature: Library Edit
  Scenario: User Edits Pre-existing Movie
    Given the user is logged in and on their "Library View" page
    When the user clicks the Edit button for a movie
    When the user checks the modal box for Favorite
    When the user checks the modal box for Watched
    When the user enters "It's an enjoyable film" into the modal User Comments box
    When the user clicks the Save Changes button
    Then the movie's information should have been updated