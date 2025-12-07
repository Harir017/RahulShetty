package com.RahulShetty.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.RahulShetty.Base.BasePage;

public class ProtoComercePage extends BasePage {
	@FindBy(xpath = "(//input[@name='name'])[1]")
	WebElement NameField;

	@FindBy(xpath = "//input[@name='email']")
	WebElement EmailField;

	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	WebElement PasswordField;

	@FindBy(xpath = "//input[@id='exampleCheck1']")
	WebElement CheckBox;

	@FindBy(css = "#exampleFormControlSelect1")
	WebElement GenderDropdown;

	@FindBy(css = "#inlineRadio1")
	WebElement StudentRadioButton;

	@FindBy(css = "#inlineRadio2")
	WebElement EmployedRadioButton;

	@FindBy(css = "input[name='bday']")
	WebElement CalendarField;

	@FindBy(xpath = "(//input[@name='name'])[2]")
	WebElement BindingName;

	@FindBy(css = ".alert.alert-success.alert-dismissible")
	WebElement SuccessAlert;

	@FindBy(css = "input.btn.btn-success")
	WebElement successBtn;

	public ProtoComercePage(WebDriver Driver) {
		super(Driver);
	}

	public void EnterName(String Name) {
		NameField.clear();
		NameField.sendKeys(Name);

	}

	public void EnterEmail(String Mail) {
		EmailField.clear();
		EmailField.sendKeys(Mail);
	}

	public void EnterPassword(String pass) {
		PasswordField.clear();
		PasswordField.sendKeys(pass);
	}

	public void selectIcecreamCheckbox() {
		if (!CheckBox.isSelected()) {
			CheckBox.click();
		}
	}

	public void selectGender(String gender) {
		 if (gender == null || gender.trim().isEmpty()) {
		        throw new RuntimeException("Gender value is empty in Excel!");
		    }
		Select select = new Select(GenderDropdown);
		select.selectByVisibleText(gender);
	}

	public void SelectEmployment(String Employment) {
		if (Employment.equalsIgnoreCase("Student")) {
			StudentRadioButton.click();
		} else if (Employment.equalsIgnoreCase("employed")) {
			EmployedRadioButton.click();
		}
	}

	public void EnterDOB(String DOB) {
		CalendarField.clear();
		CalendarField.sendKeys(DOB);
	}

	public void clickSubmit() {
		successBtn.click();
	}

	public String GetSuccessMessage() {
		return SuccessAlert.getText();
	}
}
