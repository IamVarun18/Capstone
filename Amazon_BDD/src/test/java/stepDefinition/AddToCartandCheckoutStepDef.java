package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;

public class AddToCartandCheckoutStepDef {
	WebDriver driver = Hooks.driver;
	ExtentTest test = Hooks.test;
	AddToCartPage atcp;
	boolean result;

	@Given("user has search for {string} and logged in with {string} and {string}")
	public void user_has_searched_for_with_and(String item, String email, String password) {
		atcp = new AddToCartPage(driver, test);
		atcp.login(email, password);
		atcp.searchProduct(item);
	}

	@When("user clicks on a product and clicks Add to Cart")
	public void user_clicks_on_a_product_and_clicks_add_to_cart() {
		result = atcp.addToCart();
	}

	@Then("the product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
		Assert.assertTrue(result);
	}

	@Given("user has one item in cart and logged in with {string} and {string}")
	public void user_has_one_item_in_cart_and_logged_in_with_and(String email, String password) {
		atcp = new AddToCartPage(driver, test);
		atcp.login(email, password);

	}

	@When("user increases quantity")
	public void user_increases_quantity() {
		result = atcp.viewCart();
	}

	@Then("cart should show updated quantity and total amount updated")
	public void cart_should_show_updated_quantity_and_total_amount_updated() {
		Assert.assertTrue(result);
	}

	@Given("user is logged in with {string} and {string} and has items in cart")
	public void user_is_logged_in_with_and_and_has_items_in_cart(String email, String password) {
		atcp = new AddToCartPage(driver, test);
		atcp.login(email, password);
	}

	@When("user proceeds to checkout and selects saved address and payment method")
	public void user_proceeds_to_checkout_and_selects_saved_address_and_payment_method() {
		atcp.viewCart();
		result = atcp.checkOut();
	}

	@Then("the order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
		System.out.println("Payment done .... Order SucessFully");
		Assert.assertTrue(result);
	}

}
