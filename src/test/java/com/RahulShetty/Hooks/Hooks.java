package com.RahulShetty.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.Reports.ExtentManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	@Before
	public void setUp(Scenario scenario) {
		LaunchBrowser();
		ExtentManager.test = ExtentManager.extent.createTest(scenario.getName());
		ExtentManager.test.log(Status.INFO, "Scenario Started; " + scenario.getName());

	}

	@After

	public void tearDown(Scenario scenario) {

		try {
			if (scenario.isFailed()) {

				String base64Screenshot = ((TakesScreenshot) DriverFactory.getDriver())
						.getScreenshotAs(OutputType.BASE64);

				ExtentManager.test.fail("Scenario Failed",
						MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
			} else {
				ExtentManager.test.log(Status.PASS, "Scenario passed");
			}

		} catch (Exception e) {
			ExtentManager.test.log(Status.WARNING, "Error in tearDown: " + e.getMessage());
		}

		if (DriverFactory.getDriver() != null) {
			DriverFactory.getDriver().quit();
		}

		ExtentManager.extent.flush();
	}
}
