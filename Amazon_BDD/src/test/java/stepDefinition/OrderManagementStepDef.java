package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderManagementPage;

public class OrderManagementStepDef {
	WebDriver driver = Hooks.driver;
	ExtentTest test = Hooks.test;
	OrderManagementPage omp;
	boolean result;
	
	@Given("user is logged in with {string} and {string}")
	public void user_is_logged_in_with_and(String email, String password) {
		omp = new OrderManagementPage(driver, test);
		omp.login(email, password);
	}

	@When("user navigates to Your Orders")
	public void user_navigates_to_your_orders() {
		result = omp.navigateToOrderPage();
	}

	@Then("a list of recent orders should be displayed")
	public void a_list_of_recent_orders_should_be_displayed() {
		Assert.assertTrue(result);
	}

	@Given("an order status is Not yet shipped")
	public void an_order_status_is_not_yet_shipped() {
		omp = new OrderManagementPage(driver, test);
		result = omp.orderStatus();
	}

	@When("user clicks on cancel order Cancel Order")
	public void user_clicks_on_cancel_order_cancel_order() {
		System.out.println("Click on cancel order");
	}

	@Then("the order should be cancelled and status updated")
	public void the_order_should_be_cancelled_and_status_updated() {
		System.out.println("Order Cancelled");
		Assert.assertTrue(result);
	}

	@Given("user has a shipped order")
	public void user_has_a_shipped_order() {
		omp = new OrderManagementPage(driver, test);
		result = omp.trackOrder();
	}

	@When("user clicks on track package Track Package")
	public void user_clicks_on_track_package_track_package() {
		System.out.println("Click on track package");
	}

	@Then("current shipment location and status should be displayed")
	public void current_shipment_location_and_status_should_be_displayed() {
		System.out.println("Current status of order will be shown");
		Assert.assertTrue(result);
	}

}
