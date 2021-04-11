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

import java.util.List;
import java.util.Map;

public class contactsStepDef {

    @Given("the user logged inas {string}")
    public void the_user_Logged_inas(String string) {
        // Write code here that turns the phrase above into concrete actions
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        String username= ConfigurationReader.get(string+"_username");
        String password = ConfigurationReader.get(string+"_password");
        LoginPage loginPage=new LoginPage();
        BrowserUtils.waitFor(3);
        loginPage.login(username,password);
    }
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username = null;
        String password = null;
        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        //send username and password
        new LoginPage().login(username, password);
    }

    @Then("the user should see the following options")
    public void the_user_should_see_the_following_options(List<String> menu) {
        DashboardPage dashboardPage=new DashboardPage();
        List<String> ActList=BrowserUtils.getElementsText(dashboardPage.menuOptions);
        Assert.assertEquals(menu,ActList);
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuOptions),menu);

        System.out.println(BrowserUtils.getElementsText(dashboardPage.menuOptions));
        System.out.println(menu.size());
        System.out.println(menu.toString());
        System.out.println(menu.get(2));
    }


    @When("the user logs in with following credentials")
    public void the_user_logs_in_with_following_credentials(Map<String,String> userCredentials) {
        String username=userCredentials.get("username");
        String password=userCredentials.get("password");
        new LoginPage().login(username,password);
        }

    @Then("the user should login with valid names")
    public void the_user_should_login_with_valid_names(Map<String,String> userCredentials) {
    String Expname=userCredentials.get("name")+" "+userCredentials.get("surname");
    //String Actname=new DashboardPage().userName.getText();
    String Actname=new DashboardPage().getUserName();
    Assert.assertEquals("verify names ",Expname,Actname);
        System.out.println(Expname+"  act name = "+Actname);
    }


    @Given("the user enter the driver information")
    public void the_user_enter_the_driver_information() {
    new LoginPage().login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer int1) {
        String pagenum=new ContactsPage().pageNumber.getAttribute("value");
        int pagenumber=Integer.parseInt(pagenum);
        System.out.println(pagenumber);
        Assert.assertTrue(pagenumber==int1);
    }

    @Given("the user enter sales manager information")
    public void the_user_enter_sales_manager_information() {
        new LoginPage().login(ConfigurationReader.get("sales_manager_username"),ConfigurationReader.get("sales_manager_password"));
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> options) {
    DashboardPage dashboardPage=new DashboardPage();
    dashboardPage.waitUntilLoaderScreenDisappear();
    List<String> menuOpt=BrowserUtils.getElementsText(dashboardPage.menuOptions);
        System.out.println(options.toString()+" == "+menuOpt.toString());
    Assert.assertEquals(menuOpt,options);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> cred) {
        new LoginPage().login(cred.get("username"),cred.get("password"));
        System.out.println(cred.get("firstname")+" "+cred.get("lastname"));
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        
    String title=Driver.get().getTitle();
        System.out.println(title+"title");
        Assert.assertEquals("Dashboard",title);
    }




}
