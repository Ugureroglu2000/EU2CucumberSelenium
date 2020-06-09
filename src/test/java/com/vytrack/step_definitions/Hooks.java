package com.vytrack.step_definitions;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   System.out.println("\t coming from Before");
    }

    @After
    public void tearDown(Scenario scenario){
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png","screenshot");
            }
            Driver.closeDriver();
    }

    @Before("@db")
    public void setUpDB(){
        System.out.println("\t coming BEFORE from DB");
    }

    @After("@db")
    public void tearDownDB(){
        System.out.println("\tThis is AFTER coming from DBn");
    }

}
