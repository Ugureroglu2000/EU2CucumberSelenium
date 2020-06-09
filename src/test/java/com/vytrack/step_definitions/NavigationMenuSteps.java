package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuSteps {


    @Given("User Logged in as sales manager")
    public void user_Logged_in_as_sales_manager() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Logged in as sales manager");
    }
    @Given("User is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is in Log in Page");
//        String Exp="hello";
//        String Act="hi";
//        Assert.assertEquals("lets see",Exp,Act);
    }
    @When("User enters the valid credentials")
    public void user_enters_the_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user enters credentials and logged in");

    }

    @When("User click Fleet module and Vehicle")
    public void user_click_Fleet_module_and_Vehicle() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Click Fleet module Vehicle Tab");
    }

    @Then("User can see the Title of page")
    public void user_can_see_the_Title_of_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Verify the Title of the page is as expected ");
    }

    @When("User click Marketting module campaigns")
    public void user_click_Marketting_module_campaigns() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Click Marketting module Campaigns Tab");
    }
    @When("User click Activities module calender events")
    public void user_click_Activities_module_calender_events() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Click Activities module Calender Events Tab");
    }


    @When("the user navigates {string} {string}")
    public void the_user_navigates(String tab, String module) {
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.navigateToModule(tab,module);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
    }

    @Then("the title contains {string}")
    public void the_title_contains(String string) {
        BrowserUtils.waitFor(2);
        String ActTitle=Driver.get().getTitle();
       // System.out.println(ActTitle);
       // System.out.println(string);
        Assert.assertTrue(ActTitle.contains(string));
    }














}
