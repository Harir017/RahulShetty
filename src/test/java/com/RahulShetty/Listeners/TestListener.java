package com.RahulShetty.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.RahulShetty.Driver.DriverFactory;

public class TestListener implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {

		DriverFactory.setTestError(result.getThrowable());
	}
}
