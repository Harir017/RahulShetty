package com.RahulShetty.Stepdefs;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.Pages.CartPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefs extends BaseTest {
	CartPage page;

	@Given("user is on Greenkart Page")
	public void userIsOnGreenkartPage() {
		NavigateTo(prop.getProperty("CartURl"));
		page = new CartPage(DriverFactory.getDriver());
	}

	@When("user adds {string} with quantity {int} to the cart")
	public void userAddsWithQuantityToTheCart(String ProductName, Integer Quantity) {
		page.addProductToCart(ProductName, Quantity);

	}

	@When("user opens the cart")
	public void userOpensTheCart() {
		page.clickCart();
	}

	@Then("cart popup should show correct products with quantity")
	public void cartPopupShouldShowCorrectProductsWithQuantity(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> expectedRows = dataTable.asMaps(String.class, String.class);
		Map<String, Integer> actualCartData = page.getCartPopupItems();

		for (Map<String, String> expected : expectedRows) {
			String expectedProduct = expected.get("product");
			int expectedQty = Integer.parseInt(expected.get("qty"));

			Assert.assertTrue(actualCartData.containsKey(expectedProduct),
					"Product missing in cart popup: " + expectedProduct);

			Assert.assertEquals(expectedQty, actualCartData.get(expectedProduct));

		}

	}

	@When("user proceeds to checkout")
	public void userProceedsToCheckout() {
		page.proceedToCheckout();
	}

	@Then("checkout page should display correct product details")
	public void checkoutPageShouldDisplayCorrectProductDetails(io.cucumber.datatable.DataTable dataTable) {
		Map<String, Map<String, Integer>> actualData = page.getCheckoutData();
		List<Map<String, String>> expectedRows = dataTable.asMaps();

		for (Map<String, String> expected : expectedRows) {
			String product = expected.get("product");
			int expectedQty = Integer.parseInt(expected.get("qty"));
			int expectedPrice = Integer.parseInt(expected.get("price"));
			int expectedTotal = Integer.parseInt(expected.get("total"));

			Map<String, Integer> actual = actualData.get(product);

			Assert.assertEquals(actual.get("qty"), expectedQty);
			Assert.assertEquals(actual.get("price"), expectedPrice);

			Assert.assertEquals(actual.get("qty") * actual.get("price"), actual.get("total"));

			Assert.assertEquals(actual.get("total"), expectedTotal);

		}
	}

	@Then("total amount should be calculated correctly")
	public void totalAmountShouldBeCalculatedCorrectly() {
		int calculatedTotal = page.getCalculatedGrandTotal();
		int finalPayableAmount = page.getFinalPayableAmount();

		Assert.assertEquals(calculatedTotal, finalPayableAmount,
				"Mismatch between calculated total and final payable amount");
	}

	@When("user places the order")
	public void userPlacesTheOrder() {
		page.userPlacesTheOrder();
	}

	@When("user selects country as {string}")
	public void userSelectsCountryAs(String country) {
		page.selectCountry(country);
	}

	@When("user accepts terms and conditions")
	public void userAcceptsTermsAndConditions() {
		page.acceptTerms();
	}

	@When("user proceeds with the order")
	public void userProceedsWithTheOrder() {
		page.ClickProceed();
	}

	@Then("order should be placed successfully")
	public void orderShouldBePlacedSuccessfully() {
		String msg = page.getSuccessMessage();

		Assert.assertTrue(msg.contains("order has been placed successfully"), "Order success message not displayed");
	}

}
