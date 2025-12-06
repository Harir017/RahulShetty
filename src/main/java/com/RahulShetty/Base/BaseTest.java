package com.RahulShetty.Base;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static Properties prop;
	public static Logger log = LogManager.getLogger(BaseTest.class);

	public void LaunchBrowser() {
		log.info("Loading config properties...");
		prop = ConfigReader.initProperties();
		String browser = prop.getProperty("browser");
		log.info("Browser selected: " + browser);

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched successfully");
		}
		DriverFactory.setDriver(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Implicit wait set to 10 seconds");
		driver.manage().window().maximize();
		log.info("Window maximized");

	}

	public void NavigateTo(String URL) {
		DriverFactory.getDriver().get(URL);
		log.info("Navigated to: " + URL);

	}
}
