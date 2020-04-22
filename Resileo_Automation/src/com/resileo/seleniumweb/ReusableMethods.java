package com.resileo.seleniumweb;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethods extends ObjectRepository {
	public WebDriver browser;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	FileUtilities drawData = new FileUtilities();
	
	//ExtentReport 
	public static ExtentReports extent = new ExtentReports("allclass.html", true);
	public static ExtentTest test;
	
	// For Application Login. Please change the "Change This" Part For your
	// Application
	public void InitiateTest(String LogPerformance) throws Exception {
		if (LogPerformance == "LogPerformanceYes") {

			System.out.print("Failed to Run ");

		} else if (LogPerformance == "LogPerformancechrome") {
			System.setProperty("webdriver.chrome.driver",
					"lib/chromedriver.exe");
			
			//For Headless
	     	ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless","window-size=1366,768");
			
			browser = new ChromeDriver(options);//For Headless Operation
		//	browser = new ChromeDriver();//For Normal Operation 
		} else {
			
			browser = new FirefoxDriver();
		}
	}

	// For Application Login. Please change the "Change This" Part For your
	// Application
	public void login() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername)).sendKeys("sangeethas@resileo-labs.com");
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword)).sendKeys("appedo");
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	
	public void loginrt() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername)).sendKeys("rajasreek@softsmith.com");
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword)).sendKeys("appedo");
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	public void loginRK() throws Exception

	{

		browser.get("https://apm.appedo.com");
		browser.manage().window().maximize();
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername)).sendKeys("rajasreek@softsmith.com");
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword)).sendKeys("smith");
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}

	public void loginN() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 1));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 1));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	

	public void loginNalini() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 2));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 2));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}

	public void loginNagas() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 3));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 3));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}

	public void loginMithi() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 4));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 4));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	
	public void sysTestlogin() throws Exception

	{

	browser.get("https://test.appedo.com");
	browser.manage().window().maximize();
	browser.findElement(getObject(appedo_login_txtUsername)).clear();
	browser.findElement(getObject(appedo_login_txtUsername)).sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 5));
	browser.findElement(getObject(appedo_login_txtPassword)).clear();
	browser.findElement(getObject(appedo_login_txtPassword)).sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 5));
	browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	public void loginS() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername)).sendKeys("ssaranya.resileo@gmail.com");
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword)).sendKeys("appedo");
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	
	public void loginYamini() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 6));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 6));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	public void loginKalai() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 7));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 7));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	public void loginD() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 8));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 8));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	
	public void loginA() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 9));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 9));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	
	public void loginTK() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		browser.findElement(getObject(appedo_login_txtUsername)).clear();
		browser.findElement(getObject(appedo_login_txtUsername))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 1, 10));
		browser.findElement(getObject(appedo_login_txtPassword)).clear();
		browser.findElement(getObject(appedo_login_txtPassword))
				.sendKeys(drawData.getdata("TestData.xlsx", "Login", 2, 10));
		browser.findElement(getObject(appedo_login_btnlogin)).click();
	}
	
	public void launchURL() throws Exception

	{

		browser.get("https://test.appedo.com");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	}

	// For Application Login. Please change the "Change This" Part For your
	// Application
	public void logout() throws Exception {
		browser.findElement(getObject(appedo_signout)).click();

	}

	public static double getRandomNumber() {
		double x = Math.random();
		return x;
	}

	public static char randomSeriesForThreeCharacter() {
		Random r = new Random();
		char random_3_Char = (char) (48 + r.nextInt(47));
		return random_3_Char;
	}

	public void setBrowser(WebDriver browser) {
		this.browser = browser;
	}

	// Synchronization Point
	public void WaitforObject(String ObjectName) throws Exception {
		WebDriverWait wait = new WebDriverWait(browser, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getObject(ObjectName)));
	}

	// Is element Present
	public boolean isElementPresent(By by) {
		try {
			browser.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// For Handling Alerts
	public boolean isAlertPresent() {
		try {
			browser.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	// Closing alerts
	public String closeAlertAndGetItsText() {
		try {
			Alert alert = browser.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
