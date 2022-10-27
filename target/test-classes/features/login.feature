Feature: Login
  Scenario Outline: MIS-20 Login with Correct Credentials
    Given the user is on the login page
    When the user inputs "<Username>" into the username field
    When the user inputs "<Password>" into the password field
    When the user clicks the login button
    Then the user should be on their "Library View" page
    Examples:
      | Username      | Password            |
      | griffy        | hunter2             |
      | sahraee       | pass2pass           |
      | asaah         | passwordsareawesome |
      | andrewwashere | coolerbeans         |


  Scenario: Incorrect Login, Valid Username
    Given the user is on the login page
    When the user inputs "griffy" into the username field
    When the user inputs "p@55w.rd" into the password field
    When the user clicks the login button
    Then the user should recieve an alert containing the text "Invalid Password"

  Scenario: Invalid Username/Account Creation Prompt
    Given the user is on the login page
    When the user inputs "OCusernamePLSnoSteal" into the username field
    When the user inputs "oregano" into the password field
    When the user clicks the login button
    Then the user should receive an alert containing the text "Invalid Username. Would you like to create a new account?"
    When the user accepts the alert
    Then the user should be redirected to the "Create Account" page
