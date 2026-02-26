package com.RahulShetty.Base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

		    ChromeOptions options = new ChromeOptions();

		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("profile.autofill_profile_enabled", false);
		    prefs.put("profile.autofill_enabled", false);
		    prefs.put("autofill.profile_enabled", false);
		    prefs.put("autofill.credit_card_enabled", false);
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.default_content_setting_values.notifications", 2);

		    options.setExperimentalOption("prefs", prefs);

		    options.addArguments("--disable-save-password-bubble");
		    options.addArguments("--disable-autofill-keyboard-accessory-view");
		    options.addArguments("--disable-features=AutofillServerCommunication");

		   // options.addArguments("--headless=new");
		    // options.addArguments("--no-sandbox");
		    // options.addArguments("--disable-dev-shm-usage");

		    WebDriverManager.chromedriver().clearDriverCache().setup();
		    driver = new ChromeDriver(options);
		    log.info("Chrome browser launched successfully");
		}
		DriverFactory.setDriver(driver);
		driver.manage().deleteAllCookies();
		log.info("All cookies cleared");
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
