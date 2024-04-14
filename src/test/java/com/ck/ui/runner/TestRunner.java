package com.ck.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Do not need @RunWith in TestNg (Requires with JUnit)
//@RunWith(Cucumber.class)

@CucumberOptions(
		// path of feature file
		features = {"src/test/resources/features"},
		// path of step definition file
		glue = {"com.ck.ui.stepdefination", "com.ck.ui.apphooks"},
		/*
		 * pretty - This provides more verbose output
		 * usage - time taken by each stepDefination
		 * dryRun -  check whether all feature file steps have corresponding step definitions
		 * "html:target/cucumber-reports" ,
		 * "json:target/cucumber-reports/Cucumber.json" - report in json format
		 * 
		 */
		plugin = {"pretty", 
				"html:target/cucumber/report.html", 
				"json:target/cucumber/Cucumber.json",
				// extent-spark report adapter
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		//tags = {"@foo and not @bar"} to run specific tags
		// more readable o/p
		monochrome = true
		)

/*
 * AbstractTestNGCucumberTests - Runs each cucumber scenario found in the features as a separate test.
 * Need to extend if using TestNG (Not required with JUnit)
 */
public class TestRunner extends AbstractTestNGCucumberTests{

}
