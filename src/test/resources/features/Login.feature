@login
Feature: Users should be able to login
    @TruckDriver  @smoke
    Scenario: Login as a driver
      Given the user is on the login page
      When the user enters the driver credentials
      Then the user should login
   @SalesManager @db
    Scenario: Login as a Sales Manager
    Given the user is on the login page
    When the user enters the Sales Manager credentials
    Then the user should login
  @storeManager   @smoke
    Scenario: Login as Store Manager
    Given the user is on the login page
    When the user enters the Store Manager credentials
    Then the user should login
      # comments
