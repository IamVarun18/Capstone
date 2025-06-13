package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Reporter;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	final String url = "https://www.amazon.com/";

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.test = test;
	}

	public boolean validateLoginPage() {
		boolean result = false;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
			String loginUrl = driver.getCurrentUrl();
			if (loginUrl.equals(url)) {
				result = true;
				Reporter.generateReport(driver, test, Status.PASS, "Login Page Open");
			} else {
				Reporter.generateReport(driver, test, Status.FAIL, "Failed to load in login page");
			}
			return result;
		} catch (Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Failed to load in login page");
			return result;
		}
	}

	public boolean validateLogin(String uEmail, String pwd) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
			driver.findElement(Locators.loginBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.continueBtn));
			driver.findElement(Locators.loginEmail).sendKeys(uEmail);
			driver.findElement(Locators.continueBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.signBtn));
			driver.findElement(Locators.password).sendKeys(pwd);
			driver.findElement(Locators.signBtn).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginVerify));
			Reporter.generateReport(driver, test, Status.PASS, "User Entered login Details");
			return true;
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Something wrong in login...try again");
			return false;
		}
	}

	public boolean loginSuccess() {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginVerify));
			Reporter.generateReport(driver, test, Status.PASS, "Login success");
			return true;
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Login failed");
			return false;
		}

	}

}
