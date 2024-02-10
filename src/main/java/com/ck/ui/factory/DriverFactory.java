package com.ck.ui.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	// Using ThreadLocal for parallel execution
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static final long TIMEOUT = 5;

	public WebDriver initDriver(String browser) {

		System.out.println("Initialising browser : " + browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			driver.set(new FirefoxDriver());
			break;
		case "edge":
			driver.set(new EdgeDriver());
			break;
		default:
			System.out.println("Invalid browser passed : " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return driver.get();
	}
}
