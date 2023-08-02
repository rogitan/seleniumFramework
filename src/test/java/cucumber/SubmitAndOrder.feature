@tag
Feature: Purchase Order for Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Add to Cart Test
    Given I am logged in with username <username> and password <password>
    When I add the product <productName> to cart
    And Checkout <country> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed in confirmation page

    Examples: 
      | username  					 | password  | productName  | country     |
      | rogi.g.tan@gmail.com | P@ssword1 | zara coat 3  | Philippines |
