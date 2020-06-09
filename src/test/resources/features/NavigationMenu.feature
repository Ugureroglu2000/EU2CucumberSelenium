@navigation
  Feature: sales managers should be able to navigate to pages using the top menu.
    @vehicles
    Scenario: sales manager can see vehicles
      Given User Logged in as sales manager
      When User click Fleet module and Vehicle
      Then User can see the Title of page
    @campaigns
    Scenario: sales manager can see campaigns
      Given User Logged in as sales manager
      When User click Marketting module campaigns
      Then User can see the Title of page
    @events
      Scenario: sales manager can see calender events
        Given User Logged in as sales manager
        When User click Activities module calender events
        Then User can see the Title of page

    Scenario: user can navigate between modules and tabs