Feature: User Signup and Account Deletion on Automation Exercise

  Background:
    When the user navigates to 'http://automationexercise.com'

  
  Scenario: Navigate to Signup/Login page
    When the user clicks on 'Signup / Login' button
    Then 'New User Signup!' should be visible

  Scenario: Successful user signup
    When the user clicks on 'Signup / Login' button
    And enters a valid name and email address
    And clicks on 'Signup' button
    Then the user should be redirected to the account information page
    And the user fills in all required fields
    And clicks on 'Create Account' button
    Then 'Account Created!' message should be displayed

  Scenario: Login with valid credentials
    When the user clicks on 'Signup / Login' button
    And enters valid email and password
    And clicks on 'Login' button
    Then 'Logged in as username' should be visible

  Scenario: Login with invalid credentials
    When the user clicks on 'Signup / Login' button
    And enters invalid email and password
    And clicks on 'Login' button
    Then 'Your email or password is incorrect!' error message should be displayed

  Scenario: Delete user account
    Given the user is logged in
    When the user clicks on 'Delete Account' button
    Then 'Account Deleted!' message should be displayed
    And the user clicks 'Continue' button

  Scenario: Signup with existing email
    When the user clicks on 'Signup / Login' button
    And enters a name and an already registered email address
    And clicks on 'Signup' button
    Then 'Email Address already exist!' error message should be displayed