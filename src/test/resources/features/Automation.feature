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