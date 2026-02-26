package com.RahulShetty.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.RahulShetty.Base.BasePage;
import com.RahulShetty.testdata.CheckoutTestData;

public class ShopCart extends BasePage {

	@FindBy(name = "search")
	WebElement SearchBar;

	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement SearchIcon;

	@FindBy(id = "input-guest")
	WebElement GuestRadioButton;

	@FindBy(name = "firstname")
	WebElement FirstName;

	@FindBy(name = "lastname")
	WebElement LastName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "shipping_address_1")
	WebElement Address;

	@FindBy(name = "shipping_city")
	WebElement City;

	@FindBy(name = "shipping_postcode")
	WebElement Postcode;

	@FindBy(id = "input-shipping-country")
	WebElement Country;

	@FindBy(id = "input-shipping-zone")
	WebElement Region;

	By productTitles = By.cssSelector("div.product-thumb h4 a");
	By productCards = By.cssSelector("div.product-thumb");
	By cartButton = By.xpath("//div/button[contains(@class,'dropdown-toggle')]");
	By checkoutLink = By.xpath("//a[contains(@href,'route=checkout/checkout')]");
	By newsletterToggle = By.cssSelector("input[name='newsletter']");
	By continueBtn = By.id("button-register");
	By ChooseShip = By.id("button-shipping-methods");
	By ModalShip = By.id("modal-shipping");
	By ShipRadio = By.cssSelector("label[for='input-shipping-method-flat-flat']");
	By ContinueShip = By.id("button-shipping-method");
	By ChoosePay = By.id("button-payment-methods");
	By ModalPay = By.id("modal-payment");
	By PayRadio = By.cssSelector("label[for='input-payment-method-cod-cod']");
	By ContinuePay = By.cssSelector("#modal-payment #button-payment-method");

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

		for (WebElement product : driver.findElements(productTitles)) {
			if (product.getText().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	public void addSpecificProductToCart(String productName) {
		waitForElementToBeVisible(productCards);

		List<WebElement> products = driver.findElements(productCards);

		for (WebElement product : products) {
			String name = product.findElement(By.cssSelector("h4 a")).getText();

			if (name.equalsIgnoreCase(productName)) {
				WebElement addToCartBtn = product.findElement(By.cssSelector("form button[type='submit']"));
				jsClick(addToCartBtn);
				break;
			}
		}
	}

	public void ClicAddtoCart() {
		WebElement cart = driver.findElement(cartButton);
		jsClick(cart);
	}

	public void clickCheckoutFromCartDropdown() {
		WebElement checkout = driver.findElement(checkoutLink);
		jsClick(checkout);
	}

	public ShopCart openShippingModal() {
		waitForElementToBeVisible(ChooseShip);
		jsClick(driver.findElement(ChooseShip));
		waitForElementToBeVisible(ModalShip);
		return this;
	}

	public ShopCart selectShippingMethod() {
		waitForElementToBeVisible(ShipRadio);
		jsClick(ShipRadio);
		return this;
	}

	public ShopCart confirmShippingMethod() {
		jsClick(driver.findElement(ContinueShip));
		waitForElementInvisible(ModalShip);
		waitForElementToBeVisible(ChoosePay);
		return this;
	}

	public ShopCart openPayModal() {
		waitForElementToBeVisible(ChoosePay);
		waitForElementToBeClickable(ChoosePay);
		jsClick(driver.findElement(ChoosePay));
		waitForElementToBeVisible(ModalPay);
		return this;
	}

	public ShopCart SelectPayRadio() {
		waitForElementToBeVisible(PayRadio);
		jsClick(PayRadio);
		return this;
	}

	public ShopCart ConfirmPayMethod() {
		waitForElementToBeClickable(ContinuePay);
		jsClick(driver.findElement(ContinuePay));
		return this;
	}

	public void fillFormAndConfirmOrder() throws InterruptedException {

		click(GuestRadioButton);

		FirstName.sendKeys(CheckoutTestData.FIRST_NAME);
		LastName.sendKeys(CheckoutTestData.LAST_NAME);
		email.sendKeys(CheckoutTestData.EMAIL);
		Address.sendKeys(CheckoutTestData.ADDRESS1);
		City.sendKeys(CheckoutTestData.CITY);
		Postcode.sendKeys(CheckoutTestData.POSTCODE);

		new Select(Country).selectByVisibleText("India");
		waitForElementToBeClickable(Region);
		new Select(Region).selectByVisibleText("Tamil Nadu");

		jsClick(driver.findElement(newsletterToggle));
		jsClick(driver.findElement(continueBtn));

		openShippingModal().selectShippingMethod().confirmShippingMethod();

		Thread.sleep(2000);

		openPayModal().SelectPayRadio().ConfirmPayMethod();

	}
}
