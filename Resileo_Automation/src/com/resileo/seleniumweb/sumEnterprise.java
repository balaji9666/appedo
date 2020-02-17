package com.resileo.seleniumweb;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class sumEnterprise extends ReusableMethods {
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String sumeditname;
	String urTestName;
	String EditTestName;
	String DeleteTestName;
	String sumName;
	String EnterpriseName = "demo1";

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		login();
	}

	@Test
	public void createSUM() {
		try {
			FileUtilities drawData = new FileUtilities();
			test = extent.startTest("SUM Creation with Enterprise", "Enterprise-Creating SUM module with URL");
			// Verify Login
			WaitforObject(appedo_verifyLogin);
			String LoginUserName = browser.findElement(By.xpath("//button[@class='mat-button ng-star-inserted']"))
					.getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(LoginUserName)) {
				test.log(LogStatus.PASS, LoginUserName + "Login Successful");
			} else {
				test.log(LogStatus.FAIL, "failed");
			}
			browser.findElement(getObject(appedo_dropdown_enterprise)).click();
			String selectedEnterprise = "//span[contains(text(),'" + EnterpriseName + "')]";
			System.out.println();
			Actions obj = new Actions(browser);
			WebElement choosen = browser.findElement(By.xpath(selectedEnterprise));
			obj.moveToElement(choosen).click().perform();
			Thread.sleep(2000);
			WaitforObject(appedo_link_EndUserMonitors);
			// Click on end user monitor
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();
			Thread.sleep(1000);
			
			// Click on add icon
			Thread.sleep(2000);
			WaitforObject(appedo_addSum);
			browser.findElement(getObject(appedo_addSum)).click();
			// Enter details in fields
			browser.findElement(getObject(appedo_sum_txtTestName)).click();
			browser.findElement(getObject(appedo_sum_txtTesturl)).click();
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_sum_warning)).clear();
			browser.findElement(getObject(appedo_sum_critical)).click();
			browser.findElement(getObject(appedo_sum_critical)).clear();
			browser.findElement(getObject(appedo_sum_minBreachCount)).click();
			browser.findElement(getObject(appedo_sum_minBreachCount)).clear();
			// Validate test name field
			WaitforObject(appedo_sum_validatetxtTestName);
			if (browser.findElement(getObject(appedo_sum_validatetxtTestName)).getText()
					.contains("You must enter a value")) {
				test.log(LogStatus.PASS, "SUM Testname validation is successful");
			} else {
				test.log(LogStatus.FAIL, "SUM Testname validation failed");
			}
			// Validate threshold values fields
			if (browser.findElement(getObject(appedo_sum_validateWarning)).getText()
					.equalsIgnoreCase("You must enter a value")) {
				test.log(LogStatus.PASS, "Warning Threshold field validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Warning Threshold field validation failed");
			}
			// Validate Critical values fields
			if (browser.findElement(getObject(appedo_sum_validateCritical)).getText()
					.equalsIgnoreCase("You must enter a value")) {
				test.log(LogStatus.PASS, "Critical Threshold validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Critical Threshold validation failed");
			}
			// Validate Breach Count
			if (browser.findElement(getObject(appedo_sum_validateMinBreachCount)).getText()
					.equalsIgnoreCase("You must enter a value")) {
				test.log(LogStatus.PASS, "Min Breach Count validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Min Breach Count validation failed");
			}
			String alphabet = "abc";
			sumName = drawData.getdata("TestData.xlsx", "SUM", 1, 1) + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_sum_txtTestName)).sendKeys(sumName);
			browser.findElement(getObject(appedo_sum_warning)).sendKeys("5");
			// browser.findElement(getObject(appedo_sum_warning)).sendKeys(drawData.getdata("TestData.xlsx",
			// "SUM", 3, 1));
			browser.findElement(getObject(appedo_sum_critical)).sendKeys("10");
			// browser.findElement(getObject(appedo_sum_critical)).sendKeys(drawData.getdata("TestData.xlsx",
			// "SUM", 4, 1));
			// browser.findElement(getObject(appedo_sum_minbreachcount)).sendKeys(drawData.getdata("TestData.xlsx",
			// "SUM", 5, 1));
			browser.findElement(getObject(appedo_sum_minBreachCount)).sendKeys("15");
			browser.findElement(getObject(appedo_sum_country)).click();
			WaitforObject(appedo_sum_selectCtry);
			browser.findElement(getObject(appedo_sum_selectCtry)).click();
			browser.findElement(getObject(appedo_sum_city)).click();
			WaitforObject(appedo_sum_selectCity);
			browser.findElement(getObject(appedo_sum_selectCity)).click();
			Actions action = new Actions(browser);
			action.sendKeys(Keys.ESCAPE).build().perform();
			WaitforObject(appedo_sum_btnSave);
			// Save SUM
			browser.findElement(getObject(appedo_sum_btnSave)).click();
			// Validate test URL
			if (browser.findElement(getObject(appedo_sum_validateTestUrl)).getText()
					.equalsIgnoreCase("Must have URL configured")) {
				test.log(LogStatus.PASS, "Test URL validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Test URL validation failed");
			}
			browser.findElement(getObject(appedo_sum_txtTesturl)).sendKeys("http://test.appedo.com");
			// Verify SUM Test added
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_sum_btnSave)).click();
			WaitforObject(appedo_db_verify);
			String saveSUM = "Successfully added sum test";
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(saveSUM)) {
				test.log(LogStatus.PASS, "SUM Module Enterprise for Owner : " + saveSUM);
			} else {
				test.log(LogStatus.FAIL, "Failed to save SUM");
			}
			Thread.sleep(2000);
			WaitforObject(appedo_sum_viewGraph);
			// Click on edit icon created recently
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				EditTestName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[4]")).getText()
						.toString();
				if (EditTestName.equalsIgnoreCase(sumName)) {
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[8]")).click();
					WaitforObject(appedo_drilDownicon);
					if (browser.findElement(getObject(appedo_drilDownicon)).isDisplayed()) {
						test.log(LogStatus.PASS, "SUM Module Enterprise for Owner :Graphs viewed Successfully");
					} else {
						test.log(LogStatus.FAIL, "SUM Module :Graphs view Failed");
					}
					// Move slider
					Thread.sleep(1000);
					browser.findElement(getObject(appedo_sum_viewGraph_slider12hrs)).click();
					WaitforObject(appedo_sum_viewGraph_btnapplySelection);
					browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).click();
					WaitforObject(appedo_sum_viewGraph_btnapplySelection);
					if (browser.findElement(getObject(appedo_sum_viewGraph_btnapplySelection)).isDisplayed()) {
						test.log(LogStatus.PASS, "SUM Module Enterprise for Owner :Slider Moved successfully");
					} else {
						test.log(LogStatus.FAIL, "SUM Module :Slider Moved Failed");
					}
					browser.navigate().back();
					extent.endTest(test);
					extent.flush();
					// Click Logout
					WaitforObject(appedo_signout);
					Thread.sleep(2000);
					browser.findElement(getObject(appedo_signout)).click();
					Thread.sleep(1000);
					WaitforObject(appedo_verifyLogout);
					// Verify Sign out
					if (browser.findElement(getObject(appedo_verifyLogout)).isDisplayed()) {
						test.log(LogStatus.PASS, "Signout Successful");
					} else {
						test.log(LogStatus.FAIL, "Signout failed");
					}
					extent.endTest(test);
					extent.flush();
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			System.out.println(e.getMessage());
			String Snapshot1 = Utility.captureScreenshot(browser, this.getClass().getSimpleName() + Utility.Datetime());
			String image = test.addScreenCapture(Snapshot1);
			test.log(LogStatus.FAIL, "Test Failed", image);
			extent.endTest(test);
			extent.flush();
		}
	}

	@After
	public void teardown() throws Exception {
		browser.close();
	}
}
