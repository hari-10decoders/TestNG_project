
@tag
Feature: Check the User account functionality in Ninja tutorial
	
  @tag1
  Scenario: I want to check the logIn fucntionality in Ninja tutorial
    Given I will open Ninja tutorial home page
    When I navigate the login page
    And I Enter the E-mail ID
    And I Enter the password
    Then I click the login button it should navigate to logged-In page.
    
   