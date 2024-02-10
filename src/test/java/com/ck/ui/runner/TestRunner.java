package com.ck.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Do not need RunWith in TestNg (Requires with JUnit)
//@RunWith(Cucumber.class)

@CucumberOptions(
		// path of feature file
		features = {"src/test/resources/features"},
		// path of step definition file
		glue = {"com.ck.ui.stepdefination", "com.ck.ui.apphooks"},
		plugin = {"pretty"}
		)

/*
 * AbstractTestNGCucumberTests - Runs each cucumber scenario found in the features as a separate test.
 */
public class TestRunner extends AbstractTestNGCucumberTests{

}
