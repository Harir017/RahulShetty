package com.RahulShetty.Stepdefs;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.Pages.ShopCart;
import com.RahulShetty.utils.ProductDBHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDBStepDef extends BaseTest {
	ShopCart page;
	int productId = 50;
	int quantityBefore;
	int quantityAfter;

	@Given("product {string} exists in database")
	public void productExistsInDatabase(String string) {
		int qty = ProductDBHelper.getProductQuantity(productId);
		assertTrue(qty > 0, "Product not found in DB");
	}

	@Given("I capture the quantity of product {string} from database")
	public void iCaptureTheQuantityOfProductFromDatabase(String string) {

		quantityBefore = ProductDBHelper.getProductQuantity(productId);
	}

	@When("user places an order for product {string} in store")
	public void userPlacesAnOrderForProductInStore(String string) throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver();
		driver.switchTo().newWindow(WindowType.TAB);
		NavigateTo(prop.getProperty("StoreLink"));

		page = new ShopCart(driver);
		page.EnterProduct(string);
		Assert.assertTrue(page.isProductDisplayed(string));
		page.addSpecificProductToCart(string);
		
		page.ClicAddtoCart();
		page.clickCheckoutFromCartDropdown();
		page.fillFormAndConfirmOrder();
		
	}

	@Then("product quantity of {string} in database should reduce by {int}")
	public void productQuantityOfInDatabaseShouldReduceBy(String string, Integer int1) {

	}
}
