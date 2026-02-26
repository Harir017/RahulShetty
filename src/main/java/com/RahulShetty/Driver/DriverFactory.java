package com.RahulShetty.Driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private static ThreadLocal<Throwable> tlError = new ThreadLocal<>();

	public static void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void setTestError(Throwable error) {
		tlError.set(error);
	}

	public static Throwable getTestError() {
		return tlError.get();
	}
}
