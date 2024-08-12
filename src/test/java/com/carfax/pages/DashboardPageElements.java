package com.carfax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carfax.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(xpath = "//span[@class='cgh__account-username']")
	public WebElement actualAccountName;
	
	public String  expectedAccountName = "mesut_erol_tr";

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}

}
