Feature: Library Edit
  Scenario: User Edits Pre-existing Movie
    Given the user is logged in and on their "Library View" page
    When the user checks the box to mark a movie as Favorite
    When the user checks the box to mark a movie as Watched
    When the user clicks the Edit button to edit User Comments
    When the user enters "It's an enjoyable film" into the User Comments input
    When the user clicks the Save Changes button
    Then the movie's information should have been updated