package com.carfax.testbase;

import com.carfax.pages.*;

public class PageInitializer extends BaseClass {
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;

	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
	}
}
