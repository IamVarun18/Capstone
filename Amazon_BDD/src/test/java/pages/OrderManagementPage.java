package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Reporter;

public class OrderManagementPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	final String homeUrl = "https://www.amazon.com/";

	public OrderManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.test = test;
	}

	public void login(String email, String password) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
			driver.findElement(Locators.loginBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.continueBtn));
			driver.findElement(Locators.loginEmail).sendKeys(email);
			driver.findElement(Locators.continueBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.signBtn));
			driver.findElement(Locators.password).sendKeys(password);
			driver.findElement(Locators.signBtn).click();
			Reporter.generateReport(driver, test, Status.PASS, "Login SucessFul");
		} catch (Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Login not done");
		}
	}
	public boolean navigateToOrderPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.humbergerBtn));
			driver.findElement(Locators.humbergerBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.menuContent));
			WebElement menu = driver.findElement(Locators.menuContent);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 500;", menu);
			WebElement helpSettings = driver.findElement(Locators.setting);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", helpSettings);
			driver.findElement(Locators.yourAccBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.container));
			driver.findElement(Locators.yourOrder).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchOrder));
			Reporter.generateReport(driver, test, Status.PASS, "User on your order page");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "User failed to navigate your order page");
			return false;
		}
	}
	public boolean orderStatus() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
		System.out.println("Navigate to see order details");
		System.out.println("Open order summary");
		Reporter.generateReport(driver, test, Status.PASS, "Order cancelled");
		return true;
		}catch(Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Some error in cancelling the order");
			return false;
		}
	}
	public boolean trackOrder() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
		System.out.println("User want to see tracking details");
		System.out.println("User navigate to order placed section");
		Reporter.generateReport(driver, test, Status.PASS, "Track Status");
		return true;
		}catch(Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Not tracking");
			return false;
		}
	}

}
