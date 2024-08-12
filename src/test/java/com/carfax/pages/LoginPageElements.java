package com.carfax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carfax.utils.CommonMethods;
import com.carfax.utils.ConfigReader;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "cgh-account-login-button")
	public WebElement linkLoginPage;
	
	@FindBy(id = "username")
	public WebElement inputUsername;

	@FindBy(id = "password")
	public WebElement inputPassword;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;

	@FindBy(id = "error-element-password")
	public WebElement errorElement;
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

	public void adminLogin() {
		sendText(inputUsername, ConfigReader.getProperty("username"));
		sendText(inputPassword, ConfigReader.getProperty("password"));
		click(loginButton);
	}

}
