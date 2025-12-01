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
	
	@runThis
Scenario: Verify user can switch to new window 

	Given user is on Automation Practice Page 
	When user click on open window button 
	Then user should switch to the new window 
	And the new window title should contain "QAClick Academy" 
	And user closes the new window and returns to parent 
		