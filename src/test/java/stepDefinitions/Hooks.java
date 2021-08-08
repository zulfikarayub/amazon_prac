package stepDefinitions;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.AfterStep;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Cucumber.CucumberAutomation.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

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
