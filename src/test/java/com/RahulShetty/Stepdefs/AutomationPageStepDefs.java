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

	@When("user selects the following checkboxes:")
	public void userSelectsTheFollowingCheckboxes(io.cucumber.datatable.DataTable dataTable) {
		page = new AutomationPage(DriverFactory.getDriver());
		for (String checkbox : dataTable.asList()) {
			page.selectCheckbox(checkbox);
		}
	}

	@Then("the following checkboxes should be selected:")
	public void theFollowingCheckboxesShouldBeSelected(io.cucumber.datatable.DataTable dataTable) {
		for (String checkbox : dataTable.asList()) {
			Assert.assertTrue(page.isCheckboxSelected(checkbox), checkbox + " is not selected");
		}

	}

	@When("user types {string} in suggestion box")
	public void userTypesInSuggestionBox(String Text) {
		page.TypeInSuggestionBox(Text);
	}

	@When("user selects {string} from suggestions")
	public void userSelectsFromSuggestions(String value) {
		page.SelectSuggestion(value);
	}

	@Then("suggestion selected value should be {string}")
	public void suggestionSelectedValueShouldBe(String Expected) {
		Assert.assertEquals(page.GetselectedSuggestion(), Expected);
	}

	@When("user click on open window button")
	public void userClickOnOpenWindowButton() {
		page.OpenWindow();
	}

	@Then("user should switch to the new window")
	public void userShouldSwitchToTheNewWindow() {
		page.SwitchtoNewWindow();
	}

	@Then("the new window title should contain {string}")
	public void theNewWindowTitleShouldContain(String Title1) {
		Assert.assertTrue(page.GetNewWindowTile(Title1), "Title does not contain expected text!");
	}

	@Then("user closes the new window and returns to parent")
	public void userClosesTheNewWindowAndReturnsToParent() {
		page.closeChildWindow();
	}

	@When("user clicks Open Tab")
	public void userClicksOpenTab() {
		page.ClickOpenTab();
	}

	@Then("user should switch to the new tab")
	public void userShouldSwitchToTheNewTab() {
		page.SwitchtoNewWindow();
	}

	@Then("new tab title should contain {string}")
	public void newTabTitleShouldContain(String TabTitle) {
		Assert.assertTrue(page.getTabTitle().contains(TabTitle), "New tab title mismatch");
	}

	@When("user enters {string} in alert input box")
	public void userEntersInAlertInputBox(String string) {
		page.EnterAlertName(string);
	}

	@When("user clicks the Alert button")
	public void userClicksTheAlertButton() {
		page.ClickAlterButton();
	}

	@Then("alert message should contain {string}")
	public void alertMessageShouldContain(String string) {
		String Actual = DriverFactory.getDriver().switchTo().alert().getText();
		Assert.assertTrue(Actual.contains(string), "Actual alert: " + Actual);
		DriverFactory.getDriver().switchTo().alert().accept();
	}

	@When("user clicks the Confirm button")
	public void userClicksTheConfirmButton() {
		page.ClickConfirmButton();
	}

	@Then("confirm alert message should contain {string}")
	public void confirmAlertMessageShouldContain(String string) {
		String actual = DriverFactory.getDriver().switchTo().alert().getText();
		Assert.assertTrue(actual.contains(string), "Actual confirm alert: " + actual);
	}

	@Then("user accepts the confirm alert")
	public void userAcceptsTheConfirmAlert() {
		DriverFactory.getDriver().switchTo().alert().accept();
	}

	@When("user enters {string} into the display field")
	public void userEntersIntoTheDisplayField(String string) {
		page.TypeinDisplayBox(string);
	}

	@Then("the text field should be displayed")
	public void theTextFieldShouldBeDisplayed() {
		Assert.assertTrue(page.IsDisplayFieldVisible(), "Field is NOT visible!");
	}

	@When("user clicks Hide button")
	public void userClicksHideButton() {
		page.ClickHideButton();
	}

	@Then("the text field should be hidden")
	public void theTextFieldShouldBeHidden() {
		Assert.assertFalse(page.IsDisplayFieldVisible(), "Field is still visible!");
	}

	@When("user clicks Show button")
	public void userClicksShowButton() {
		page.ClickShowButton();
	}

	@Then("the text field should be displayed again")
	public void theTextFieldShouldBeDisplayedAgain() {
		Assert.assertTrue(page.IsDisplayFieldVisible(), "Field is NOT visible after clicking Show!");
	}
}
