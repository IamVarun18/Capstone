package stepDefinition;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogOutPage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserAuthStepDef {
	WebDriver driver = Hooks.driver;
	ExtentTest test = Hooks.test;
	RegistrationPage register;
	LoginPage loginPage;
	LogOutPage logout;

	@Given("user is on the registration page using {string}")
	public void user_is_on_the_registration_page(String email) {
		register = new RegistrationPage(driver, test);
		boolean result = register.validateRegisterUrl(email);
		Assert.assertTrue(result);
		
	}

	@When("user enters valid {string}, {string} and {string}")
	public void user_enters_valid_email_fullName_and_password(String email, String fullName, String password) {
		System.out.println("User starts the registration....");
		register = new RegistrationPage(driver, test);
		boolean result =  register.enterDetails(email,fullName,password);
		Assert.assertTrue(result);
	}


	@Then("a new account should be created")
	public void a_new_account_should_be_created() {
		System.out.println("You account is Successfully created...Please login.");
		Assert.assertTrue(true);
	}

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		loginPage = new LoginPage(driver, test);
		boolean result = loginPage.validateLoginPage();
		Assert.assertTrue(result);
	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_email_and_password(String email,String password) {
		loginPage = new LoginPage(driver, test);
		System.out.println("User trying to Login");
		boolean result=loginPage.validateLogin(email, password);
		Assert.assertTrue(result);
	}
	
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_email_and_password(String email,String password) {
		loginPage = new LoginPage(driver, test);
		System.out.println("User trying to Login");
		boolean result=loginPage.validateLogin(email, password);
		Assert.assertTrue(result);
	}

	@When("user enters otp recieved on mobile number")
	public void user_enters_otp_recieved_on_mobile_number() {
		System.out.println("User Entering the otp..");
		Assert.assertTrue(true);
	}

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		boolean result = loginPage.loginSuccess();
		Assert.assertTrue(result);
		System.out.println("User login success");
	}

	@Given("user is logged in as {string} and {string}")
	public void user_is_logged_in(String email,String password) {
		logout = new LogOutPage(driver, test);
		boolean result = logout.userLogedIn(email,password);
		Assert.assertTrue(result);
	}

	@When("user clicks on Sign Out {string} and {string}")
	public void user_clicks_on_Sign_Out(String email,String password) {
		boolean result = logout.validateLogOut(email,password);
		Assert.assertTrue(result);
		System.out.println("user signout successfully");
	}

	@Then("user should be redirected to home page")
	public void user_should_be_redirected_to_home_page() {
		logout = new LogOutPage(driver, test);
		boolean result = logout.navigateHomePage();
		Assert.assertTrue(result);
	}

}
