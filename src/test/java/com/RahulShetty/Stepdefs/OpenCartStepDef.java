package com.RahulShetty.Stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.Pages.OpenCartLoginPage;
import com.RahulShetty.Pages.ShopCart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenCartStepDef extends BaseTest {
	OpenCartLoginPage page;
	ShopCart cart;

	@Given("User is on OpneCart LoginPage")
	public void userIsOnOpneCartLoginPage() {
		NavigateTo(prop.getProperty("OpenCartLogin"));
		DriverFactory.getDriver().navigate().refresh();
		page = new OpenCartLoginPage(DriverFactory.getDriver());
	}

	@Given("admin is logged into OpenCartPage")
	public void adminIsLoggedIntoOpenCartPage() {
		page.EnterUserName();
		page.EnterPassword();
		page.ClickSubmit();
	}

	@Given("admin notes an existing product {string}")
	public void adminNotesAnExistingProduct(String ProductName) {
		boolean productexists = page.IsProductPresent(ProductName);

		Assert.assertTrue(productexists, "Product " + ProductName + " not found in Admin Products list");
	}

	@When("user searches for {string} in store")
	public void userSearchesForInStore(String string) {
		WebDriver driver = DriverFactory.getDriver();
		driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
		NavigateTo(prop.getProperty("StoreLink"));
		cart = new ShopCart(DriverFactory.getDriver());
		cart.EnterProduct(string);

	}

	@Then("product {string} should be displayed")
	public void productShouldBeDisplayed(String ProductName) {
		boolean resultPage = cart.isProductDisplayed(ProductName);

		Assert.assertTrue(resultPage, "Product " + ProductName + " not displayed in search results");

	}

	@Then("search endpoint should return status {int}")
	public void searchEndpointShouldReturnStatus(Integer int1) {
		   int status =
			        given()
			            .queryParam("route", "product/search")
			            .queryParam("search", "iphone")
			        .when()
			            .get("https://demo3x.opencartreports.com/index.php")
			        .getStatusCode();

			    Assert.assertTrue(
			        status == 200 || status == 503,
			        "Unexpected status code: " + status
			    );

	}

}
