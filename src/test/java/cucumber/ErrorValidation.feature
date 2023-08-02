@tag
Feature: Error Validation for Login Page
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Error Validation for Incorrect User credential
  	Given I landed on Ecommerce Page
    When I am logged in with username <username> and password <password>
		Then I will see "Incorrect email or password." message is displayed
		
    Examples: 
      | username  				 | password  |
      | rogi.tan@gmail.com | P@ssword1 |
