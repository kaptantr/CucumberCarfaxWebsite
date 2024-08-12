@Login
Feature: Login Functionality

	Background: 
		Given I navigated to the Login Page  
	
	@smoke @regression
  Scenario: Valid Login
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in

	@smoke @regression
  Scenario: Invalid Login with Valid Username and Invalid Password
    When I enter a valid username
    And I enter a invalid password
    And I click on the login button
    Then I validate that I am not logged in
    
  @smoke @regression
  Scenario: Invalid Login with Invalid Username and Valid Password
    When I enter a invalid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am not logged in
    
  @smoke @regression
  Scenario: Invalid Login with Invalid Username and Invalid Password
    When I enter a invalid username
    And I enter a invalid password
    And I click on the login button
    Then I validate that I am not logged in
    
  @smoke @regression
  Scenario: Invalid Login with Empty Username and Empty Password
    When I enter an empty username
    And I enter an empty password
    And I click on the login button
    Then I validate that I am not logged in with the empty datas