package com.ck.ui.stepdefination;

import com.ck.ui.factory.DriverFactory;
import com.ck.ui.pages.LoginPage;
import com.ck.ui.pages.ProductPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
	
	@Given("user has already logged in")
	public void user_has_already_logged_in(DataTable dataTable) {
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLogin();
	}

	@Given("user is on products page")
	public void user_is_on_products_page() {
		productPage.clickOnProducts();
		productPage.validateProductsPage();
	}

	@When("user add backpack to cart")
	public void user_add_backpack_to_cart() {
		productPage.clickOnBackpack();
	}

	@When("user click on cart")
	public void user_click_on_cart() {
		productPage.clickonCart();
	}

	@Then("user get the cart detail")
	public void user_get_the_cart_detail() {
		productPage.validateCartDetails();
	}
}
