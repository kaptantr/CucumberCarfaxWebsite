package com.neotech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		// we can specify which feature/features to run
		features = "resources/features/",

		// we can specify where the code for the features are located
		glue = "com.carfax.steps",

		// if true, it does not run the java classes. Only checks the feature files
		// if they are glued to some java code
		dryRun = false,

		// tags can do the same thing groups on TestNG do
		tags = "@smoke",

		monochrome = true,
		
		plugin = {
				// Prints the gherkin steps to the console
				"pretty",
				
				// Creates and saves the basic html report on the target folder
				"html:target/cucumber-default-report.html",
				
				// Stores every step of the execution to a json file
				"json:target/cucumber.json",
				
				// To run failed test scenarios present in the text file
				"rerun:target/failed.txt"
				}
		)

public class TestRunner {

}
