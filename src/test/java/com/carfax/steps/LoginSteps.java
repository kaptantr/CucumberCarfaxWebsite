package com.carfax.steps;

import org.junit.Assert;

import com.carfax.utils.CommonMethods;
import com.carfax.utils.ConfigReader;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

	@Given("I navigated to the Login Page")
	public void i_navigated_to_the_login_page() {
	    click(login.linkLoginPage);
	}
	
	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.inputUsername, ConfigReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.inputPassword, ConfigReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.loginButton);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {
		String actual = dashboard.actualAccountName.getText();

		if (actual.contains(dashboard.expectedAccountName)) {
			Assert.assertTrue(true);
			System.out.println("Test Passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("Test failed");
		}
	}

	@When("I enter a invalid username")
	public void i_enter_a_invalid_username() {
		sendText(login.inputUsername, new Faker().name().username());
	}

	@When("I enter a invalid password")
	public void i_enter_a_invalid_password() {
		sendText(login.inputPassword, new Faker().internet().password());
	}

	@When("I enter an empty username")
	public void i_enter_an_empty_username() {
		sendText(login.inputUsername, "");
	}

	@When("I enter an empty password")
	public void i_enter_an_empty_password() {
		sendText(login.inputPassword, "");
	}
	
	@Then("I validate that I am not logged in")
	public void i_validate_that_i_am_not_logged_in() {
		String errorText = login.errorElement.getText();

		if (login.errorElement.isDisplayed() &&  errorText.contains("Wrong")) {
			Assert.assertTrue(true);
			System.out.println("Test Passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("Test failed");
		}
	}	
	
	@Then("I validate that I am not logged in with the empty datas")
	public void i_validate_that_i_am_not_logged_in_with_the_empty_datas() {

		if (login.inputUsername.getAttribute("required") != null && login.inputPassword.getAttribute("required") != null) {
			Assert.assertTrue(true);
			System.out.println("Test Passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("Test failed");
		}
	}

}
