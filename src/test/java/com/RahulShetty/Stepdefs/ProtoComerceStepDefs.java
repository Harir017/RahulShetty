package com.RahulShetty.Stepdefs;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Driver.DriverFactory;
import com.RahulShetty.Pages.ProtoComercePage;
import com.RahulShetty.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProtoComerceStepDefs extends BaseTest {
	ProtoComercePage page;
	List<Map<String, String>> excelRows;

	@Given("user is on ProtoCommerce Practice Form")
	public void userIsOnProtoCommercePracticeForm() {
		NavigateTo(prop.getProperty("protoURL"));
		DriverFactory.getDriver().navigate().refresh();
		page = new ProtoComercePage(DriverFactory.getDriver());
	}

	@When("user enters name {string}")
	public void userEntersName(String string) {
		page.EnterName(string);
	}

	@Given("user loads excel test data")
	public void userLoadsExcelTestData() {
		String excelpath = System.getProperty("user.dir") + "/src/test/resources/testdata/ProtoData.xlsx";
		excelRows = ExcelReader.getData(excelpath, "Sheet1");
		System.out.println("Loaded Excel rows: " + excelRows.size());
	}

	@When("user fills and submits form for all excel rows")
	public void userFillsAndSubmitsFormForAllExcelRows() {
		for (Map<String, String> row : excelRows) {
			page.EnterName(row.get("Name"));
			page.EnterEmail(row.get("Email"));
			page.EnterPassword(row.get("Password"));
			page.selectIcecreamCheckbox();
			
			
			System.out.println("GENDER READ FROM EXCEL => >" + row.get("Gender") + "<");
			
			page.selectGender(row.get("Gender"));
			page.SelectEmployment(row.get("Employment"));
			page.EnterDOB(row.get("DOB"));

			page.clickSubmit();

			String msg = page.GetSuccessMessage();
			Assert.assertTrue(msg.contains("Success"), "Success message not found for row: " + row.get("Name"));

		}

	}

	@Then("all rows should be submitted successfully")
	public void allRowsShouldBeSubmittedSuccessfully() {
		System.out.println("✔ All Excel rows submitted successfully!");
	}
}
