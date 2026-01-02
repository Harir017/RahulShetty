@cart 
Feature: Place order successfully in Greenkart application as a user 
		I want to add products to cart and place an order
  		So that I can verify end-to-end shopping flow

Background: 
	Given user is on Greenkart Page 
	
Scenario: Verify user can place order successfully with selected Products 
	When user adds "Brocolli" with quantity 1 to the cart 
	And user adds "Cucumber" with quantity 2 to the cart 
	And user adds "Tomato" with quantity 3 to the cart 
	
	And user opens the cart 
	
	Then cart popup should show correct products with quantity 
		| product  | qty |
		| Brocolli | 1   |
		| Cucumber | 2   |
		| Tomato   | 3   |
		
	When user proceeds to checkout 
	
	Then checkout page should display correct product details 
		| product  | qty | price | total |
		| Brocolli | 1   | 120   | 120   |
		| Cucumber | 2   | 48    | 96    |
		| Tomato   | 3   | 16    | 48    |
		
	And total amount should be calculated correctly 
	
	When user places the order 
	And user selects country as "India" 
	And user accepts terms and conditions 
	And user proceeds with the order 
	
	Then order should be placed successfully 
	
	
  