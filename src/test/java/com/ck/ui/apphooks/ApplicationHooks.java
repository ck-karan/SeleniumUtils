package com.ck.ui.apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ck.ui.factory.ConfigReader;
import com.ck.ui.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory factory;
	private WebDriver driver;
	private ConfigReader reader;
	private Properties props;
	
	public DriverFactory getFactory() {
		return factory;
	}
	public void setFactory(DriverFactory factory) {
		this.factory = factory;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	@Before(order = 0)
	public void getProperty() {
		reader = new ConfigReader();
		props = reader.initProps();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = props.getProperty("browser");
		factory = new DriverFactory();
		driver = factory.initDriver(browserName);
	}
	
	@After(order = 1)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 0)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			// take scenreenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcPath, "image/png", screenshotName);
		}
	}
	
}
