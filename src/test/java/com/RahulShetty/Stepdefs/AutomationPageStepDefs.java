package com.RahulShetty.Stepdefs;

import org.testng.Assert;

import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.Pages.AutomationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationPageStepDefs {
	AutomationPage page;

	@Given("user is on Automation Practice Page")
	public void user_is_on_automation_practice_page() {
		page = new AutomationPage(DriverFactory.getDriver());
	}

	@When("user selects Radio1")
	public void user_selects_radio1() {
		page.selectRadio1();
	}

	@Then("only Radio1 should be selected")
	public void only_radio1_should_be_selected() {
		Assert.assertTrue(page.isRadio1selected());
		Assert.assertFalse(page.isRadio2selected());
		Assert.assertFalse(page.isRadio3selected());

	}

	@When("user selects Radio2")
	public void user_selects_radio2() {
		page.selectRadio2();

	}

	@Then("only Radio2 should be selected")
	public void only_radio2_should_be_selected() {
		Assert.assertTrue(page.isRadio2selected());
		Assert.assertFalse(page.isRadio1selected());
		Assert.assertFalse(page.isRadio3selected());

	}

	@When("user selects Radio3")
	public void user_selects_radio3() {
		page.selectRadio3();
		;
	}

	@Then("only Radio3 should be selected")
	public void only_radio3_should_be_selected() {
		Assert.assertTrue(page.isRadio3selected());
		Assert.assertFalse(page.isRadio1selected());
		Assert.assertFalse(page.isRadio2selected());

	}

	@When("user selects {string} from dropdown")
	public void userSelectsFromDropdown(String option) {
		page.selectDropdownByText(option);
	}

	@Then("dropdown value should be {string}")
	public void dropdownValueShouldBe(String expectedValue) {
		Assert.assertEquals(page.GetSelectedOption(), expectedValue);

	}
}
