package com.ck.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

private WebDriver driver;
	
	// By Locators
	private By title = By.xpath("//span[@class='title']");
	
	// Constructor for page
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 
	public String getTitle() {
		return driver.findElement(title).getText();
	}
}
