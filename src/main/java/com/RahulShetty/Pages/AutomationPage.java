package com.RahulShetty.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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

	@FindBy(id = "checkBoxOption1")
	WebElement Checkbox1;

	@FindBy(id = "checkBoxOption2")
	WebElement checkbox2;

	@FindBy(id = "checkBoxOption3")
	WebElement checkbox3;

	@FindBy(id = "autocomplete")
	WebElement SuggestionInput;

	@FindBy(css = "div.ui-menu-item-wrapper")
	List<WebElement> suggenstionlist;

	@FindBy(id = "openwindow")
	WebElement OpenWindowButton;

	@FindBy(xpath = "//a[@id='opentab']")
	WebElement OpenTab;

	@FindBy(xpath = "//input[@id='name']")
	WebElement EnterNameBox;

	@FindBy(xpath = "//input[@id='alertbtn']")
	WebElement AlertButton;

	@FindBy(xpath = "//input[@id='confirmbtn']")
	WebElement ConfirmButton;

	@FindBy(xpath = "//input[@id='displayed-text']")
	WebElement DisplayBox;

	@FindBy(id = "hide-textbox")
	WebElement HideButton;

	@FindBy(id = "show-textbox")
	WebElement ShowButton;

	@FindBy(css = ".table-display tbody tr")
	List<WebElement> tableRows;

	@FindBy(css = ".table-display tbody tr td")
	List<WebElement> tableData;

	@FindBy(css = ".tableFixHead table tbody tr")
	List<WebElement> FixedTableRows;

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

	public void selectCheckbox(String checkboxName) {
		switch (checkboxName.toLowerCase()) {
		case "option1":
			Checkbox1.click();
			break;
		case "option2":
			checkbox2.click();
			break;
		case "option3":
			checkbox3.click();
			break;
		}
	}

	public boolean isCheckboxSelected(String checkboxName) {
		switch (checkboxName.toLowerCase()) {
		case "option1":
			return Checkbox1.isSelected();
		case "option2":
			return checkbox2.isSelected();
		case "option3":
			return checkbox3.isSelected();
		default:
			return false;
		}

	}

	public void TypeInSuggestionBox(String Text) {
		SuggestionInput.clear();
		SuggestionInput.sendKeys(Text);

	}

	public void SelectSuggestion(String value) {

		for (WebElement option : suggenstionlist) {
			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				return;
			}
		}
		throw new RuntimeException("Option not found: " + value);
	}

	public String GetselectedSuggestion() {
		return SuggestionInput.getAttribute("value");
	}

	public void OpenWindow() {
		OpenWindowButton.click();
	}

	public void SwitchtoNewWindow() {
		String parent = driver.getWindowHandle();
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parent)) {
				driver.switchTo().window(window);
				return;
			}
		}

	}

	public boolean GetNewWindowTile(String Title) {
		return driver.getTitle().contains(Title);

	}

	public void closeChildWindow() {
		String parent = driver.getWindowHandle();
		String child = "";

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parent)) {
				child = window;
			}
		}
		driver.switchTo().window(child);
		driver.close();
		driver.switchTo().window(parent);
	}

	public void ClickOpenTab() {
		OpenTab.click();
	}

	public void OpenNewTab() {
		String parent = driver.getWindowHandle();
		for (String Tab : driver.getWindowHandles()) {
			if (!Tab.equals(parent)) {
				driver.switchTo().window(Tab);
				break;
			}
		}
	}

	public String getTabTitle() {
		return driver.getTitle();
	}

	public void EnterAlertName(String Name) {
		EnterNameBox.clear();
		EnterNameBox.sendKeys(Name);
	}

	public void ClickAlterButton() {
		AlertButton.click();
	}

	public void ClickConfirmButton() {
		ConfirmButton.click();
	}

	public void TypeinDisplayBox(String Name) {
		DisplayBox.clear();
		DisplayBox.sendKeys(Name);
	}

	public void ClickHideButton() {
		HideButton.click();
	}

	public void ClickShowButton() {
		ShowButton.click();
	}

	public boolean IsDisplayFieldVisible() {
		return DisplayBox.isDisplayed();
	}

	public int getRowCount() {
		return tableRows.size() - 1;
	}

	public String GetCellData(int row, int col) {
		WebElement rowElement = tableRows.get(row);
		List<WebElement> cells = rowElement.findElements(By.tagName("td"));
		return cells.get(col).getText().trim();
	}

	public int getFixedTableRowCount() {
		return FixedTableRows.size();
	}

	public Map<String, String> getFixedTableRowData(int RowIndex) {
		WebElement row = FixedTableRows.get(RowIndex - 1);
		List<WebElement> cell = row.findElements(By.tagName("td"));

		Map<String, String> rowdata = new HashMap<>();
		rowdata.put("Name", cell.get(0).getText());
		rowdata.put("Position", cell.get(1).getText());
		rowdata.put("City", cell.get(2).getText());
		rowdata.put("Amount", cell.get(3).getText());

		return rowdata;

	}
}
