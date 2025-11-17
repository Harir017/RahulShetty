package com.RahulShetty.Hooks;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Reports.ExtentManager;
import com.RahulShetty.utils.ScreenshotUtils;
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

		if (scenario.isFailed()) {
			String screenshotpath = ScreenshotUtils.captureSS(driver, scenario.getName());
			ExtentManager.test.log(Status.INFO, "Scenario Failed");
			ExtentManager.test.addScreenCaptureFromPath(screenshotpath);
		} else {
			ExtentManager.test.log(Status.INFO, "Scenario passed");

		}

		driver.quit();

		ExtentManager.extent.flush();

	}
}
