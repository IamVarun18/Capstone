Feature: Order Management

  Scenario Outline: View recent orders
    Given user is logged in with "<email>" and "<password>"
    When user navigates to Your Orders
    Then a list of recent orders should be displayed

		Examples:
    	| email 										| password |
    	|varun.018072001@gmail.com	| Varun@018072001|
	
  Scenario Outline: Cancel an order before shipping
    Given an order status is Not yet shipped
    When user clicks on cancel order Cancel Order
    Then the order should be cancelled and status updated


  Scenario: Track a shipped order
    Given user has a shipped order
    When user clicks on track package Track Package
    Then current shipment location and status should be displayed

