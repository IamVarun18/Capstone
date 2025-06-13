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

public class AddToCartPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	final String homeUrl = "https://www.amazon.com/";

	public AddToCartPage(WebDriver driver, ExtentTest test) {
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

	public boolean searchProduct(String item) {
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

	public boolean addToCart() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.product));
			driver.findElement(Locators.product).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.addToCartBtn));
			driver.findElement(Locators.addToCartBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.goToCartBtn));
			driver.findElement(Locators.goToCartBtn).click();
			Reporter.generateReport(driver, test, Status.PASS, "Item added to cart");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Item not added to cart");
			return false;
		}
	}

	public boolean viewCart() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartIcon));
			driver.findElement(Locators.cartIcon).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.increaseQty));
			driver.findElement(Locators.increaseQty).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.qty));
//			String str = driver.findElement(Locators.qty).getText();
			Reporter.generateReport(driver, test, Status.PASS, "Quantity increased");
			return true;

		} catch (Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Quantity not increased");
			return false;
		}
	}

	public boolean checkOut() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.proceedToCheckOutBtn));
			driver.findElement(Locators.proceedToCheckOutBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.payBtn));
			Reporter.generateReport(driver, test, Status.PASS, "CheckOut process done");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "CheckOut not done");
			return false;
		}
	}

}
