package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	// locators for UserAuth feature file
	//locators for registration process
	public static By loginBtn = By.id("nav-link-accountList");
	public static By createAccBtn = By.cssSelector(".a-button-input");
	public static By fullName = By.id("ap_customer_name");
	public static By loginEmail = By.id("ap_email_login");
	public static By newPassword = By.id("ap_password");
	public static By reTypePassword = By.id("ap_password_check");
	public static By verifyBtn = By.id("continue");
	public static By email = By.id("ap_email");
	public static By continueBtn = By.cssSelector("input.a-button-input");
	public static By emailVerifyBtn = By.cssSelector(".a-button-input");
	public static By adMobileBtn = By.cssSelector(".a-button-input notranslate");
	public static By captcha = By.id("aacb-captcha-header");
	//locator for login process
	public static By password = By.id("ap_password");
	public static By signBtn = By.id("signInSubmit");
	public static By otp = By.id("auth-mfa-otpcode");
	public static By loginVerify = By.xpath("/html/body/div[1]/header/div[1]/div[1]/div[3]/div/div[2]/a/div/span");
	public static By verifyText = By.cssSelector(".nav-link-accountList-nav-line-1");
	//logout scenerio
	public static By humbergerBtn = By.id("nav-hamburger-menu");
	public static By setting = By.xpath("//section//div[text()='Help & Settings']");
	public static By menuContent = By.id("hmenu-content");
	public static By validateSignout = By.id("continue");
	public static By signOutBtn = By.xpath("//section//div[text()='Help & Settings']/following::li[5]");
	public static By canvasBackground = By.id("hmenu-canvas-background");
	
	//locators for search and filter
	public static By searchBar = By.id("twotabsearchtextbox");
	public static By searchBtn = By.id("nav-search-submit-button");
	public static By productSearch = By.cssSelector("span.a-color-state");
	public static By filter = By.xpath("//span[text()='Sony']");
	public static By checkBox = By.xpath("//span[text()='Sony']/preceding-sibling::div");
	public static By product = By.xpath("(//div[@class='puisg-row']//descendant::h2/span)[2]");
	public static By clear = By.xpath("//span[text()='Clear']");
	
	//locators for order management
	public static By yourAccBtn = By.xpath("//section//div[text()='Help & Settings']/following::li//a[text()='Your Account']");
	public static By container = By.cssSelector(".a-container");
	public static By yourOrder = By.cssSelector(".a-box-inner");
	public static By searchOrder = By.xpath("//input[@class='a-button-input']");
	
	//locators for add to cart and checkout
	public static By addToCartBtn = By.id("add-to-cart-button");
	public static By goToCartBtn = By.xpath("(//span[@class='a-button-inner'])[6]");
	public static By cartIcon = By.xpath("(//div[@id='nav-tools']/child::a)[2]");
	public static By increaseQty = By.xpath("(//button[@class='a-declarative'])[2]");
	public static By qty = By.id("sc-subtotal-label-activecart");
	public static By proceedToCheckOutBtn = By.xpath("//input[@name='proceedToRetailCheckout']");
	public static By payBtn = By.xpath("(//span[@class='a-button-inner'])[1]");
}
