@phone
Feature: Product search validation 
Scenario: Validate product search using admin session 
	Given User is on OpneCart LoginPage 
	And admin is logged into OpenCartPage 
	And admin notes an existing product "iPhone" 
	When user searches for "iphone" in store 
	Then product "iPhone" should be displayed 
	And search endpoint should return status 200 
