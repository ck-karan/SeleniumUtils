package com.ck.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * 
 * Following POM
 * 
 */
public class LoginPage {

	private WebDriver driver;
	
	// By Locators
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	
	// Constructor for page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(this.userName).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}
	
}
