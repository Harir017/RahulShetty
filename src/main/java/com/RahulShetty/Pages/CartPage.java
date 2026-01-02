package com.RahulShetty.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.RahulShetty.Base.BasePage;

public class CartPage extends BasePage {

	@FindBy(css = ".cart-icon")
	WebElement Cart;

	@FindBy(css = "div.action-block button")
	WebElement proceedToCheckoutBtn;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement PlaceOrder;

	@FindBy(tagName = "select")
	WebElement countryDropdown;

	@FindBy(xpath = "//input[@class='chkAgree']")
	WebElement Accept;

	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement Proceed;
	
	@FindBy(xpath = "//span[contains(text(),'order has been placed successfully')]")
	WebElement successMessage;

	public CartPage(WebDriver driver) {
		super(driver);

	}

	private WebElement getProduct(String productName) {
		return driver.findElement(By.xpath("//div[@class='product'][.//h4[contains(text(),'" + productName + "')]]"));

	}

	public void addProductToCart(String productName, int quantity) {

		WebElement product = getProduct(productName);

		for (int i = 1; i < quantity; i++) {
			product.findElement(By.cssSelector("a.increment")).click();

		}
		product.findElement(By.cssSelector("button")).click();
	}

	public void clickCart() {
		Cart.click();

	}

	public Map<String, Integer> getCartPopupItems() {

		Map<String, Integer> cartData = new HashMap<>();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> rows = driver.findElements(By.cssSelector("ul.cart-items li.cart-item"));

		for (WebElement row : rows) {

			String product = row.findElement(By.cssSelector("p.product-name")).getText().split("-")[0].trim();

			String qtyText = (String) js.executeScript("return arguments[0].textContent;",
					row.findElement(By.cssSelector("p.quantity")));

			int quantity = Integer.parseInt(qtyText.replaceAll("[^0-9]", ""));

			cartData.put(product, quantity);
		}

		return cartData;

	}

	public void proceedToCheckout() {
		waitForElementToBeVisible(By.cssSelector("div.action-block button"));
		proceedToCheckoutBtn.click();

	}

	public Map<String, Map<String, Integer>> getCheckoutData() {
		Map<String, Map<String, Integer>> CheckOutData = new HashMap<>();

		List<WebElement> rows = driver.findElements(By.cssSelector("table.cartTable tbody tr"));

		for (WebElement row : rows) {

			String product = row.findElement(By.cssSelector("p.product-name")).getText().split("-")[0].trim();
			int qty = Integer.parseInt(row.findElement(By.cssSelector("p.quantity")).getText().trim());

			List<WebElement> amounts = row.findElements(By.cssSelector("p.amount"));

			int price = Integer.parseInt(amounts.get(0).getText().trim());
			int total = Integer.parseInt(amounts.get(1).getText().trim());

			Map<String, Integer> values = new HashMap<>();

			values.put("qty", qty);
			values.put("price", price);
			values.put("total", total);

			CheckOutData.put(product, values);
		}
		return CheckOutData;
	}

	public int getCalculatedGrandTotal() {
		int sum = 0;
		List<WebElement> rowTotals = driver.findElements(By.cssSelector("table.cartTable tbody tr td:nth-child(5)"));

		for (WebElement total : rowTotals) {
			sum += Integer.parseInt(total.getText().trim());
		}

		return sum;
	}

	public int getFinalPayableAmount() {

		waitForElementToBeVisible(By.cssSelector("div.promoWrapper"));

		String amountText = driver.findElement(By.cssSelector("span.discountAmt")).getText().trim();

		return Integer.parseInt(amountText);
	}

	public void userPlacesTheOrder() {
		PlaceOrder.click();
		waitForElementToBeVisible(By.cssSelector("select"));
	}

	public void selectCountry(String country) {
		Select select = new Select(countryDropdown);
		select.selectByVisibleText(country);

	}

	public void acceptTerms() {
		if (!Accept.isSelected()) {
			Accept.click();
		}
	}

	public void ClickProceed() {
		Proceed.click();
	}
	
	public String getSuccessMessage() {
	    waitForElementToBeVisible(
	        By.xpath("//span[contains(text(),'order has been placed successfully')]")
	    );
	    return successMessage.getText();
	}
}
