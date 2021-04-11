package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
       String url= ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user enters the driver credentials")
    public void the_user_enters_the_driver_credentials() {
        // Write code here that turns the phrase above into concrete actions
        String username=ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage=new LoginPage();
//         loginPage.login(username,password);
       loginPage.userName.sendKeys(username);
       loginPage.password.sendKeys(password);
       loginPage.submit.click();
    }


    @When("the user enters the {string} credentials")
    public void the_user_enters_the_credentials(String string) {
        // Write code here that turns the phrase above into concrete actions
        String username=ConfigurationReader.get(string+"_username");
        String password = ConfigurationReader.get(string+"_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }
    @When("the Title contains {string}")
    public void the_Title_contains(String string) {
        // Write code here that turns the phrase above into concrete actions
      //  DashboardPage dashboardPage=new DashboardPage();
        String ActTitle= Driver.get().getTitle();
        String ExpTitle=string;
        Assert.assertEquals("Verify",ActTitle,ExpTitle);
        // Driver.get().quit();

    }
    @Then("the user should login")
    public void the_user_should_login() {
        // Write code here that turns the phrase above into concrete actions
//        DashboardPage dashboardPage=new DashboardPage();
//        String ActTitle= dashboardPage.getPageSubTitle();
//        String ExpTitle="Quick Launchpad";
//        Assert.assertEquals("Verify",ActTitle,ExpTitle);


    }


    @When("the user navigates {string}{string}")
    public void the_user_navigates(String Tab, String Module) {
        // Write code here that turns the phrase above into concrete actions
        DashboardPage dashboardPage=new DashboardPage();
        BrowserUtils.waitFor(2);
        dashboardPage.navigateToModule(Tab,Module);
    }

    @Then("the default page is {string}")
    public void the_default_page_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        ContactsPage contactsPage=new ContactsPage();
        BrowserUtils.waitFor(4);
        String Act=contactsPage.pageNumber.getAttribute("value");
        String Exp=string;
        Assert.assertEquals("verify page number",Act,Exp);
    }

    @When("the user enters the Sales Manager credentials")
    public void the_user_enters_the_Sales_Manager_credentials() {
        // Write code here that turns the phrase above into concrete actions
        String username=ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }



    @When("the user enters the Store Manager credentials")
    public void the_user_enters_the_Store_Manager_credentials() {
        // Write code here that turns the phrase above into concrete actions
        String username=ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }

}
