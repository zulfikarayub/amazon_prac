package stepDefinitions;

import Cucumber.CucumberAutomation.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks extends BaseTest {


    @Before()
    public void beforeScenario(Scenario scenario) {
        getDriver();

    }

    @AfterStep
    public void driverClose(Scenario scenario) throws Exception {

        BaseTest.getScreenShot(scenario);


    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        driver.close();
        System.out.println("Driver is closed");

    }
}
