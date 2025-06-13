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

public class LogOutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;

	public LogOutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.test = test;
	}

	public boolean userLogedIn(String uEmail, String pwd) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
			driver.findElement(Locators.loginBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.continueBtn));
			driver.findElement(Locators.loginEmail).sendKeys(uEmail);
			driver.findElement(Locators.continueBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.signBtn));
			driver.findElement(Locators.password).sendKeys(pwd);
			driver.findElement(Locators.signBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.humbergerBtn));
			driver.findElement(Locators.humbergerBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.menuContent));
			WebElement menu = driver.findElement(Locators.menuContent);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 500;", menu);
			WebElement helpSettings = driver.findElement(Locators.setting);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", helpSettings);

			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.signOutBtn));
			Reporter.generateReport(driver, test, Status.PASS, "User is logged in");
			return true;
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "User Not logged in");
			return false;
		}
	}

	public boolean validateLogOut(String uEmail, String pwd) {
		driver.findElement(Locators.signOutBtn).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.validateSignout));
			Reporter.generateReport(driver, test, Status.PASS, "User Signout SuccessFully");
			return true;
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Signout Failed");
			return false;
		}
	}

	public boolean navigateHomePage() {
		driver.navigate().to("https://www.amazon.com/");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
			Reporter.generateReport(driver, test, Status.PASS, "User navigated to home page");
			return true;
		} catch (Exception te) {
			Reporter.generateReport(driver, test, Status.FAIL, "Home page navigation failed");
			return false;
		}
	}

}
