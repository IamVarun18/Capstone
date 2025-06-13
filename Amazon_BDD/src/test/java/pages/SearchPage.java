package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Reporter;

public class SearchPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	final String homeUrl = "https://www.amazon.com/";

	public SearchPage(WebDriver driver, ExtentTest test) {
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

	public boolean validateHomePage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.humbergerBtn));
			Reporter.generateReport(driver, test, Status.PASS, "User on home page");
			return true;
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "User failed to navigate home page");
			return false;
		}

	}

	public boolean searchValidProduct(String item) {
		try {
			driver.findElement(Locators.searchBar).sendKeys(item);
			driver.findElement(Locators.searchBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productSearch));
			WebElement resultTextElement = driver.findElement(Locators.productSearch);
			String resultText = resultTextElement.getText().toLowerCase();
			if (resultText.contains(item.toLowerCase())) {
				Reporter.generateReport(driver, test, Status.PASS, "Search successful for: " + item);
				return true;
			} else {
				Reporter.generateReport(driver, test, Status.FAIL, "Search item not found in results text");
				return false;
			}
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Unable to search");
			return false;
		}
	}
	public boolean searchInValidProduct(String item) {
		try {
			driver.findElement(Locators.searchBar).sendKeys(item);
			driver.findElement(Locators.searchBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productSearch));
			WebElement resultTextElement = driver.findElement(Locators.productSearch);
			String resultText = resultTextElement.getText().toLowerCase();
			if (resultText.contains(item.toLowerCase())) {
				Reporter.generateReport(driver, test, Status.PASS, "Search successful for: " + item);
				return true;
			} else {
				Reporter.generateReport(driver, test, Status.FAIL, "Search item not found in results text");
				return false;
			}
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Unable to search");
			return false;
		}
	}
	
	public boolean applyFilter() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.filter));
		
		driver.findElement(Locators.filter).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.product));
		String product = driver.findElement(Locators.product).getText();
		product=product.toLowerCase();
		if(product.contains("sony")) {
			Reporter.generateReport(driver, test, Status.PASS, "Filter applied ");
			return true;
		}else {
			Reporter.generateReport(driver, test, Status.FAIL, "Filter not applied");
			return false;
		}
		}catch(Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Filter not applied");
			return false;
		}
	}
	public boolean clearFilter() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clear));
		driver.findElement(Locators.clear).click();;
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.product));
		String product = driver.findElement(Locators.product).getText();
		product=product.toLowerCase();
		if(!product.contains("sony")) {
			Reporter.generateReport(driver, test, Status.PASS, "Filter Cleared");
			return true;
		}else {
			Reporter.generateReport(driver, test, Status.FAIL, "Filter not cleared");
			return false;
		}
		}catch(Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Filter not cleared");
			return false;
		}
	}

}
