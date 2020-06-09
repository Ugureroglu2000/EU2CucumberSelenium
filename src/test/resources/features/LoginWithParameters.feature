
  Feature: Login as different users
    Scenario: User can login
      Given the user is on the login page
      When the user enters the "sales_manager" credentials
      And the Title contains "Dashboard"
      Then the user should login