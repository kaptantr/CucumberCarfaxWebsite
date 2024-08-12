@Login
Feature: Login Functionality

  Scenario: Valid Login
    Given I navigated to the Login Page
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
