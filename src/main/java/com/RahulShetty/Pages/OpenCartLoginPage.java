package com.RahulShetty.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.RahulShetty.Base.BasePage;

public class OpenCartLoginPage extends BasePage {
	@FindBy(id = "input-username")
	WebElement UserName;

	@FindBy(id = "input-password")
	WebElement Password;

	@FindBy(css = ".btn.btn-primary")
	WebElement Submit;

	@FindBy(css = "table tbody tr")
	List<WebElement> productNames;

	public OpenCartLoginPage(WebDriver driver) {
		super(driver);
	}

	public void EnterUserName() {
		UserName.sendKeys("demo");
	}

	public void EnterPassword() {
		Password.sendKeys("demo");
	}

	public void ClickSubmit() {
		Submit.click();
	}

	public boolean IsProductPresent(String expectedProduct) {

		By rowsLocator = By.cssSelector("table tbody tr");

		waitForElementToBeVisible(rowsLocator);

		List<WebElement> rows = driver.findElements(rowsLocator);

		for (WebElement row : rows) {
			if (row.getText().contains(expectedProduct)) {
				return true;
			}
		}
		return false;
	}
}
