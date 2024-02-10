package com.ck.ui.stepdefination;

import org.testng.Assert;

import com.ck.ui.factory.DriverFactory;
import com.ck.ui.pages.LoginPage;
import com.ck.ui.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ProductPage productPage = new ProductPage(DriverFactory.getDriver());

	@Given("User is landing page")
	public void user_is_landing_page() {
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}

	@When("User gets title of the page")
	public void user_gets_title_of_the_page() {

	}

	@Then("Page title should be contains {string}")
	public void page_title_should_be_contains(String expected) {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("Title of the page : " + actualTitle);
		Assert.assertEquals(expected, actualTitle);
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}

	@When("User enters username {string}")
	public void user_enters_username(String uname) {
		loginPage.enterUserName(uname);
	}

	@When("User enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);
	}

	@When("User clicks on login")
	public void user_clicks_on_login() {
		loginPage.clickOnLogin();
	}

	@Then("User gets the span title page {string}")
	public void user_gets_the_span_title_page(String expectedTitle) {
		String actualTitle = productPage.getTitle();
		Assert.assertTrue(actualTitle.equals(expectedTitle),
				"Validating title Actual [" + actualTitle + "] : Expected [" + expectedTitle + "].");
	}
}
