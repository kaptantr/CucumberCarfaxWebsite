package com.carfax.steps;

import java.io.IOException;

import com.carfax.testbase.BaseClass;
import com.carfax.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void start() throws InterruptedException, IOException {
		BaseClass.setUp();
	}

	@After
	public void end(Scenario scenario) {

		byte[] picture;

		if (scenario.isFailed()) {
			// store the screenshot in the failed folder
			picture = CommonMethods.takeScreenShot("failed/" + scenario.getName());
		} else {
			// store the screenshot in the passed folder
			picture = CommonMethods.takeScreenShot("passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());

		BaseClass.tearDown();
	}
}
