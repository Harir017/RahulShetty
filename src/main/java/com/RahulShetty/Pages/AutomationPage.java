package com.RahulShetty.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.RahulShetty.Base.BasePage;

public class AutomationPage extends BasePage {
	@FindBy(xpath = "//input[@value='radio1']")
	WebElement radio1;

	@FindBy(xpath = "//input[@value='radio2']")
	WebElement radio2;

	@FindBy(xpath = "//input[@value='radio3']")
	WebElement radio3;

	@FindBy(id = "dropdown-class-example")
	WebElement Dropdown;

	public AutomationPage(WebDriver driver) {
		super(driver);
	}

	public void selectRadio1() {
		radio1.click();
	}

	public void selectRadio2() {
		radio2.click();
	}

	public void selectRadio3() {
		radio3.click();
	}

	public boolean isRadio1selected() {
		return radio1.isSelected();
	}

	public boolean isRadio2selected() {
		return radio2.isSelected();
	}

	public boolean isRadio3selected() {
		return radio3.isSelected();
	}

	public void selectDropdownByText(String Text) {
		Select choose = new Select(Dropdown);
		choose.selectByVisibleText(Text);
	}

	public String GetSelectedOption() {
		Select Get = new Select(Dropdown);
		return Get.getFirstSelectedOption().getText();

	}

}
