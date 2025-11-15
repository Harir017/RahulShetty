package com.RahulShetty.Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.RahulShetty.utils.ConfigReader;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;

	public void LaunchBrowser() {

		prop = ConfigReader.initProperties();
		String browser = prop.getProperty("browser");
		String Url = prop.getProperty("baseUrl");

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(Url);
	}
}
