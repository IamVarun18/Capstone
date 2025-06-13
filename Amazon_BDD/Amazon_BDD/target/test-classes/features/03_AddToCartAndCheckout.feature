Feature: Add to Cart and Checkout
	
  Scenario: Add product from search result
    Given user has search for "<item>" and logged in with "<email>" and "<password>"
    When user clicks on a product and clicks Add to Cart
    Then the product should be added to the cart
	
	Examples:
      | item    | email | password |
      | laptop  |varun.018072001@gmail.com|Varun@018072001|
	
  Scenario: Increase quantity of item in cart
    Given user has one item in cart and logged in with "<email>" and "<password>" 
    When user increases quantity
    Then cart should show updated quantity and total amount updated
	
	Examples:
    	| email 										| password |
    	| varun.018072001@gmail.com	| Varun@018072001 |
	
	
  Scenario: Checkout with saved address and payment
    Given user is logged in with "<email>" and "<password>" and has items in cart
    When user proceeds to checkout and selects saved address and payment method
    Then the order should be placed successfully

	Examples:
    	| email 										| password |
    	| varun.018072001@gmail.com	| Varun@018072001 |
  