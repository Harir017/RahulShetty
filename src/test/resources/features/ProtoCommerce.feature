@proto 
Feature: Excel Data Driven ProtoCommerce Form 

Background: 
	Given user is on ProtoCommerce Practice Form 
	And user loads excel test data 
	
Scenario: Submit form for every Excel row 
	When user fills and submits form for all excel rows 
	Then all rows should be submitted successfully