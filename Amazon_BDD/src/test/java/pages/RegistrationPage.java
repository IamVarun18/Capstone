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

public class RegistrationPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest test;
	final String captchaText = "Solve this puzzle to protect your account";
	final String REG_URL = "https://www.amazon.com/ap/register?openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&showRememberMe=true&openid.pape.max_auth_age=0&pageId=usflex&prepopulatedLoginId=&openid.assoc_handle=usflex&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&policy_handle=Retail-Checkout";
	public RegistrationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.test=test;
	}
	public boolean validateRegisterUrl(String email) {
		boolean result = false;
		try {
		//wait until login button not visible because sometimes there will be a captcha so we need to enter manually
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginBtn));
		//click on login button
		driver.findElement(Locators.loginBtn).click();
		//wait for login email field
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginEmail));
		driver.findElement(Locators.loginEmail).clear();
		driver.findElement(Locators.loginEmail).sendKeys(email);
		//click on continue
		driver.findElement(Locators.continueBtn).click();
		//wait for visibility of create account button
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.createAccBtn));
		driver.findElement(Locators.createAccBtn).click();
		String actUrl = driver.getCurrentUrl();
		System.out.println(actUrl);
		if(actUrl.equals(REG_URL)) {
			Reporter.generateReport(driver,  test,  Status.PASS, "User is on the registration page" );
			result = true;
		}else {
			Reporter.generateReport(driver, test, Status.FAIL, "User not in the registration page");
		}
		return result;
		}catch(Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "User not in the registration page");
			return false;
		}
	}
	
	public boolean enterDetails(String email,String fullName,String password) {
		boolean result =false;
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.fullName));
		driver.findElement(Locators.fullName).sendKeys(fullName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.newPassword));
		driver.findElement(Locators.newPassword).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reTypePassword));
		driver.findElement(Locators.reTypePassword).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyBtn));
		WebElement btn = driver.findElement(Locators.verifyBtn);
		if(btn.isEnabled()) {
			btn.click();
			driver.navigate().to("https://www.amazon.com/");
			Reporter.generateReport(driver,  test,  Status.PASS, "Registration Successfull...." );
			result = true;
			
		}else {
			Reporter.generateReport(driver, test, Status.FAIL, "Registration not done");
		}
		
		
		return result;
		}catch(Exception e) {
			Reporter.generateReport(driver, test, Status.FAIL, "Registration not done");
			return false;
		}
	}

}
