@accountTypes
Feature: Account types

  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"

  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates "Customers" "Accounts"
    Then the title contains "Accounts - Customers"

  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates "Customers" "Contacts"
    Then the title contains "Contacts - Customers"


  Scenario Outline: Login with Different accounts <userType>
    Given the user logged in as "<userType>"
    When the user navigates "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType      | tab        | module          | title                        |
      | driver        | Activities | Calendar Events | Calendar Events - Activities |
      | sales manager | Customers  | Accounts        | Accounts - Customers         |
      | store manager | Customers  | Contacts        | Contacts - Customers         |



  Scenario Outline: Login with different users
    Given the user logged in as "<userType>"

    Examples:
      | userType      |
      | driver        |
      | admin         |
      | sales manager |
      | store manager |