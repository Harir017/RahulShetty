Feature: Practise Page Testing 

Scenario: Verify each radio button can be selected individually 
	Given user is on Automation Practice Page 
	When user selects Radio1 
	Then only Radio1 should be selected 
	
	When user selects Radio2 
	Then only Radio2 should be selected 
	
	When user selects Radio3 
	Then only Radio3 should be selected 
	
Scenario: Verify user can select values from Dropdown 
	Given user is on Automation Practice Page 
	When user selects "Option1" from dropdown 
	Then dropdown value should be "Option1" 
	
	When user selects "Option2" from dropdown 
	Then dropdown value should be "Option2" 
	
	When user selects "Option3" from dropdown 
	Then dropdown value should be "Option3" 
	
	
Scenario: Verify user can select multiple checkbox 
	Given user is on Automation Practice Page 
	When user selects the following checkboxes: 
		| Option1 |
		| Option2 |
		| Option3 |
	Then the following checkboxes should be selected: 
		| Option1 |
		| Option2 |
		| Option3 |
		
Scenario: verify user can select country from suggestion dropdown 
	Given user is on Automation Practice Page 
	When user types "In" in suggestion box 
	And user selects "India" from suggestions 
	Then suggestion selected value should be "India" 
	
Scenario: Verify user can switch to new window 
	Given user is on Automation Practice Page 
	When user click on open window button 
	Then user should switch to the new window 
	And the new window title should contain "QAClick Academy" 
	And user closes the new window and returns to parent 
	
Scenario: Verify user can switch to new Tab 
	Given user is on Automation Practice Page 
	When user clicks Open Tab 
	Then user should switch to the new tab 
	And new tab title should contain "QAClick Academy" 
	
Scenario: verify simple alert 
	Given user is on Automation Practice Page 
	When user enters "Hariharan" in alert input box 
	And user clicks the Alert button 
	Then alert message should contain "Hello Hariharan" 
	
Scenario: Verify confirm alert works 
	Given user is on Automation Practice Page 
	When user enters "Hariharan" in alert input box 
	And user clicks the Confirm button 
	Then confirm alert message should contain "Hello Hariharan" 
	And user accepts the confirm alert 
	
	
Scenario: Verify Hide and Show functionality 
	Given user is on Automation Practice Page 
	When user enters "Hari" into the display field 
	Then the text field should be displayed 
	
	When user clicks Hide button 
	Then the text field should be hidden 
	
	When user clicks Show button 
	Then the text field should be displayed again 
	
Scenario: Verify Web Table Data 
	Given user is on Automation Practice Page 
	Then web table should have 10 rows 
	And row 1 should contain: 
		| Instructor | Rahul Shetty |
		| Course     | Selenium Webdriver with Java Basics + Advanced + Interview Guide |
		| Price      | 30 |
	And row 2 should contain: 
		| Instructor | Rahul Shetty |
		| Course     | Learn SQL in Practical + Database Testing from Scratch |
		| Price      | 25 |
		
Scenario: Verify Web Table Fixed Header 
	Given user is on Automation Practice Page 
	Then fixed header table should have 9 rows 
	And fixed row 1 should contain: 
		| Name     | Alex      |
		| Position | Engineer  |
		| City     | Chennai   |
		| Amount   | 28        |
		
	And fixed row 2 should contain: 
		| Name     | Ben        |
		| Position | Mechanic   |
		| City     | Bengaluru  |
		| Amount   | 23         |
		
Scenario: Verify Mouse Hover Options work 
	Given user is on Automation Practice Page 
	When user hovers on Mouse Hover button 
	And user clicks Top option 
	And user selects Radio1 
	Then only Radio1 should be selected 
	When user hovers on Mouse Hover button 
	And user clicks Reload option 
	Then page should reload successfully 
	
	
Scenario: Verify iframe interaction 
	Given user is on Automation Practice Page 
	When user switches to courses iframe 
	And user clicks Learning Paths inside iframe 
	Then Learning Paths option should be visible inside iframe 
	Then user switches back to main page