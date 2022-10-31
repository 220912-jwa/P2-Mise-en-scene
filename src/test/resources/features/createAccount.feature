Feature: Account Creation
  Scenario: MIS-22 Account Creation
    Given the user is on the login page
    When the user clicks the "Create Account" button
    When the user inputs "newAccount" into the username field
    When the user inputs "passpass" into the password field
    When the user clicks the "Create Account" button
    Then the user should receive an alert with the text "Account Created Successfully!"

  #Scenario: Existing Username
    #Given the user is on the login page
    #When the user clicks the "Create a New Account" button
    #When the user inputs "griffy" into the username field
    #When the user inputs "p@55w.rd" into the password field
    #When the user clicks the "Create Account" button
    #Then the user should receive an alert with the text "Username Already Taken! Please Try Another"