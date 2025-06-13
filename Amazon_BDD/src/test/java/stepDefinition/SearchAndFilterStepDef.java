package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import pages.SearchPage;

public class SearchAndFilterStepDef {
	WebDriver driver = Hooks.driver;
	ExtentTest test = Hooks.test;
	RegistrationPage register;
	SearchPage search;
	boolean result;

	@Given("user is on the Amazon home page with {string} and {string}")
	public void user_is_on_the_amazon_home_page(String email, String password) {
		search = new SearchPage(driver, test);
		search.login(email, password);
		result = search.validateHomePage();
		Assert.assertTrue(result);
	}

	@When("user searches for {string}")
	public void user_searches_for(String item) {
		search = new SearchPage(driver, test);
		result = search.searchValidProduct(item);
		Assert.assertTrue(result);
	}

	@Then("search results for {string} should be displayed")
	public void search_results_for_should_be_displayed(String string) {
		System.out.println("Result for " + string + " is displayed");
		Assert.assertTrue(result);
	}

	@When("user searches for invalid {string}")
	public void user_searches_for_invalid(String item) {
		search = new SearchPage(driver, test);
		result = search.searchInValidProduct(item);
		Assert.assertTrue(result);
	}

	@Then("no product found should displayed")
	public void no_product_found() {
		Assert.assertTrue(result);
	}

	@Given("user has searched for {string} with {string} and {string}")
	public void user_has_searched_for(String item, String email, String password) {
		search = new SearchPage(driver, test);
		search.login(email, password);
		search.searchValidProduct(item);
	}

	@When("user applies brand filter sony")
	public void user_applies_brand_filter() {
		result = search.applyFilter();
	}

	@Then("only Sony items should be listed")
	public void only_should_be_listed() {
		Assert.assertTrue(result);
	}

	@Given("user has applied brand and price filters on {string} with {string} and {string}")
	public void user_has_applied_brand_and_price_filters_on(String item, String email, String password) {
		search = new SearchPage(driver, test);
		search.login(email, password);
		search.searchValidProduct(item);
	}

	@When("user clears all filters")
	public void user_clears_all_filters() {
		search.applyFilter();
		result = search.clearFilter();
	}

	@Then("all search results for {string} should be shown again")
	public void all_search_results_for_should_be_shown_again(String string) {
		Assert.assertTrue(result);
	}
}
