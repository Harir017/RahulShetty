package com.RahulShetty.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.RahulShetty.Base.BasePage;

public class ShopCart extends BasePage {
	@FindBy(name = "search")
	WebElement SearchBar;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement SearchIcon;

	By productTitles = By.cssSelector("div.product-thumb h4 a");

	public ShopCart(WebDriver driver) {
		super(driver);

	}

	public void EnterProduct(String name) {
		SearchBar.clear();
		SearchBar.sendKeys(name);
		click(SearchIcon);
	}

	public boolean isProductDisplayed(String productName) {
		waitForElementToBeVisible(productTitles);
		List<WebElement> products = driver.findElements(productTitles);

		for (WebElement product : products) {
			if (product.getText().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}
}
