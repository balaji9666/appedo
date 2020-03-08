package com.resileo.seleniumweb;

import org.junit.*;
import static org.junit.Assert.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class avmLocation extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;

	@Before
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginD();
	}

	@Test
	public void AVMLocation() {
		try {
			test = extent.startTest("AVM Location", "Availability Location");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			// click on External Monitor Link
			Thread.sleep(6000);
			WaitforObject(appedo_link_EndUserMonitors);
			browser.findElement(getObject(appedo_link_EndUserMonitors)).click();

			// click on AVM Location Link
			Thread.sleep(7000);
			WaitforObject(appedo_linkavm_Location);
			browser.findElement(getObject(appedo_linkavm_Location)).click();

			// click on Add AVM Location Button
			Thread.sleep(2000);
			WaitforObject(appedo_addAvl);
			browser.findElement(getObject(appedo_addAvl)).click();

			// Verify validation Test URL
			browser.findElement(getObject(appedo_txtCountry)).click();
			browser.findElement(getObject(appedo_txtCity)).click();
			if (browser.findElement(getObject(appedo_validation_txtName)).getText().contains("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "AVL Country field validation is verified");
			} else {
				test.log(LogStatus.FAIL, " AVL Country field validation failed");
			}

			// Text field Add availability Location
			browser.findElement(getObject(appedo_txtCountry)).sendKeys("india");
			browser.findElement(getObject(appedo_txtState)).sendKeys("tamilnadu");
			browser.findElement(getObject(appedo_txtRegion)).sendKeys("chennai");
			browser.findElement(getObject(appedo_txtZone)).sendKeys("tuticorin");
			browser.findElement(getObject(appedo_txtCity)).sendKeys("tuticorin");
			browser.findElement(getObject(appedo_BtnSave)).click();

			// Verify AVM Test added
			WaitforObject(appedo_avm_verifyadd);
			String verifyMsg = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
			if (browser.findElement(getObject(appedo_avm_verifyadd)).getText().contains("Successfully AVM Location Created")) 
			{
				test.log(LogStatus.PASS, "AVL :" + verifyMsg);
			} else {
				test.log(LogStatus.FAIL, "AVL added failed");
			}

			// Click on Alert Icon
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_iconAlert)).click();
			
			// Verify AVM Test added
			WaitforObject(appedo_avm_verifyadd);
			String NoAlert = browser.findElement(getObject(appedo_avm_verifyadd)).getText().toString();
			if (browser.findElement(getObject(appedo_avm_verifyadd)).getText().contains(NoAlert)) 
			{
				test.log(LogStatus.PASS, "AVL :" + NoAlert);
			} else {
				test.log(LogStatus.FAIL, "AVL added failed");
			}
			Thread.sleep(5000);
			
			// Click on Add alert email
			WaitforObject(appedo_addAlert);
			browser.findElement(getObject(appedo_addAlert)).click();
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_txtemailAVL)).clear();
			browser.findElement(getObject(appedo_txtemailAVL)).sendKeys("nagaskannan94@gmail.com");
			Thread.sleep(1000);
			
			// click on save and add
			WaitforObject(appedo_BtnSaveadd);
			browser.findElement(getObject(appedo_BtnSaveadd)).click();

			// Verify alert
			WaitforObject(appedo_verify_mailAdded);
			String Msg = browser.findElement(getObject(appedo_verify_mailAdded)).getText();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(Msg)) 
			{
				test.log(LogStatus.PASS, "Alert Settings : " + Msg);
			} else {
				test.log(LogStatus.FAIL, "Alert setting failed");
			}
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_txtemailAVL)).clear();
			browser.findElement(getObject(appedo_txtemailAVL)).sendKeys("nagarajs.resileo@gmail.com");
			Thread.sleep(1000);
			
			// click on save and finish
			WaitforObject(appedo_btnSaveFinish);
			browser.findElement(getObject(appedo_btnSaveFinish)).click();
			
			// Verify alert
			WaitforObject(appedo_verify_mailAdded);
			String emailAdd = browser.findElement(getObject(appedo_verify_mailAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(emailAdd)) 
			{
				test.log(LogStatus.PASS, "Alert Settings : " + emailAdd);
			} else {
				test.log(LogStatus.FAIL, "Alert setting email added failed");
			}

			// Email Edit
			Thread.sleep(4000);
			browser.findElement(getObject(appedo_iconEdit)).click();
			browser.findElement(getObject(appedo_txtemailAVL)).clear();
			browser.findElement(getObject(appedo_txtemailAVL)).sendKeys("nagaskannan@gmail.com");
			
			// click on save and finish
			WaitforObject(appedo_btnSaveFinish);
			browser.findElement(getObject(appedo_btnSaveFinish)).click();

			// Verify alert
			WaitforObject(appedo_verify_mailAdded);
			String MsgEdit = browser.findElement(getObject(appedo_verify_mailAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(MsgEdit)) 
			{
				test.log(LogStatus.PASS, "Alert Settings : " + MsgEdit);
			} else {
				test.log(LogStatus.FAIL, "Alert setting failed");
			}
			Thread.sleep(5000);
			
			// click on save and finish
			WaitforObject(appedo_iconDelete);
			browser.findElement(getObject(appedo_iconDelete)).click();

			// Verify Delete alert
			WaitforObject(appedo_verify_mailAdded);
			String MsgDelete = browser.findElement(getObject(appedo_verify_mailAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(MsgDelete)) 
			{
				test.log(LogStatus.PASS, "Alert Settings : " + MsgDelete);
			} else {
				test.log(LogStatus.FAIL, "Alert setting failed");
			}
			browser.findElement(getObject(appedo_Btncancel)).click();
			Thread.sleep(5000);
			
			// Click on Delete
			browser.findElement(getObject(appedo_iconDel)).click();
			browser.switchTo().alert().accept();
			
			// Verify Delete alert
			WaitforObject(appedo_verify_mailAdded);
			String AVLDelete = browser.findElement(getObject(appedo_verify_mailAdded)).getText().toString();
			if (browser.findElement(getObject(appedo_verify_mailAdded)).getText().contains(AVLDelete)) 
			{
				test.log(LogStatus.PASS, "Alert Settings : " + AVLDelete);
			} else {
				test.log(LogStatus.FAIL, "Alert setting failed");
			}
			extent.endTest(test);
			extent.flush();
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
	public void tearDown() throws Exception {
		logout();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			fail(verificationErrorString);
		}
	}
}