package com.ck.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {

private WebDriver driver;
	
	// By Locators
	private By title = By.xpath("//span[@class='title']");
	private By backpack = By.id("add-to-cart-sauce-labs-backpack");
	private By cartSpan = By.xpath("//a[@class='shopping_cart_link']/span");
	private By cart = By.xpath("//a[@class='shopping_cart_link']");
	private By inventory = By.xpath("//div[@class='inventory_item_name']");
	
	// Constructor for page
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 
	public String getTitle() {
		return driver.findElement(title).getText();
	}

	public void validateProductsPage() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html", "Validating URL");
	}

	public void clickOnBackpack() {
		driver.findElement(backpack).click();
		String cartCount = driver.findElement(cartSpan).getText();
		Assert.assertEquals(cartCount, "1", "Validating product is selected.");
	}

	public void clickonCart() {
		driver.findElement(cart).click();
	}

	public void validateCartDetails() {
		String cartItem = driver.findElement(inventory).getText();
		Assert.assertEquals(cartItem, "Sauce Labs Backpack");
		
	}

	public void clickOnProducts() {
		// TODO Auto-generated method stub
		
	}
}
