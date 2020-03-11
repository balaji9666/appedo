package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class visualizer extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void createDB() {
		try {
			test = extent.startTest("DB connector Creation", "Creating DB connector");
			
			// Verify login
			WaitforObject(appedo_verifyLogin);
			String UserName = browser.findElement(getObject(appedo_verifyLogin)).getText();
			if (browser.findElement(getObject(appedo_verifyLogin)).getText().contains(UserName)) 
			{
				test.log(LogStatus.PASS, "Login Successful" + " " + UserName);
			} else {
				test.log(LogStatus.FAIL, "Login failed");
			}
			
			// Click on visualizer
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();
			
			// Click on add db icon
			WaitforObject(appedo_addDB);
			browser.findElement(getObject(appedo_addDB)).click();
			
			// validation of engine name field
			browser.findElement(getObject(appedo_db_txtHost)).click();
			if (browser.findElement(getObject(appedo_db_validateEngineName)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Engine name validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Engine name validation is failed ");
			}
			
			// validation of host field
			browser.findElement(getObject(appedo_db_txtDBuser)).click();
			WaitforObject(appedo_db_validateHost);
			if (browser.findElement(getObject(appedo_db_validateHost)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Host validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Host validation is failed");
			}
			
			// validation of DB user field
			browser.findElement(getObject(appedo_db_txtDatabase)).click();
			WaitforObject(appedo_db_validatetxtDBUser);
			if (browser.findElement(getObject(appedo_db_validatetxtDBUser)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "DB User validation is successful");
			} else {
				test.log(LogStatus.FAIL, "DB User validation is failed");
			}
			
			// validation of Database field
			browser.findElement(getObject(appedo_db_portNumber)).click();
			WaitforObject(appedo_db_validatetxtDatabase);
			if (browser.findElement(getObject(appedo_db_validatetxtDatabase)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Database validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Database validation is failed");
			}
			
			// validation of Port field
			browser.findElement(getObject(appedo_db_txtDBpassword)).click();
			WaitforObject(appedo_db_validatePort);
			if (browser.findElement(getObject(appedo_db_validatePort)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Port validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Port validation is failed");
			}
			
			// validation of DB Password field
			browser.findElement(getObject(appedo_db_txtEngineName)).click();
			WaitforObject(appedo_db_validatetxtDBPassword);
			if (browser.findElement(getObject(appedo_db_validatetxtDBPassword)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "DB Password validation is successful");
			} else {
				test.log(LogStatus.FAIL, "DB Password validation is failed");
			}
			
			// Enter values in all fields
			browser.findElement(getObject(appedo_db_txtSelectEngineName)).click();
			browser.findElement(getObject(appedo_db_txtHost)).sendKeys("35.160.246.188");
			browser.findElement(getObject(appedo_db_txtDBuser)).sendKeys("postgres");
			browser.findElement(getObject(appedo_db_txtDatabase)).sendKeys("ss_profiler");
			browser.findElement(getObject(appedo_db_portNumber)).sendKeys("5432");
			browser.findElement(getObject(appedo_db_txtDBpassword)).sendKeys("n0#ntry@^pp#d0");
			
			// Save DB connector
			browser.findElement(getObject(appedo_db_btnSave)).click();
			
			// Verify DB connector
			WaitforObject(appedo_db_verify);
			String createDB = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(createDB)) 
			{
				test.log(LogStatus.PASS, "Database Connector Created Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to create DB");
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

	public void dbEnterprise() {
		try {
			test = extent.startTest("Map Enterprise to DB", "Mapping enterprise to DB");
			
			// Click map enterprise
			WaitforObject(appedo_db_mapEnterprise);
			browser.findElement(getObject(appedo_db_mapEnterprise)).click();
			
			// Click on add enterprise
			Thread.sleep(2000);
			WaitforObject(appedo_db_addEnterprise);
			browser.findElement(getObject(appedo_db_addEnterprise)).click();
			
			// Select enterprise
			WaitforObject(appedo_db_selectEnterprise);
			browser.findElement(getObject(appedo_db_selectEnterprise)).click();
			
			// Click on add icon
			WaitforObject(appedo_db_addIcon);
			browser.findElement(getObject(appedo_db_addIcon)).click();
			
			// Click on save
			WaitforObject(appedo_db_saveEnterprise);
			browser.findElement(getObject(appedo_db_saveEnterprise)).click();
			
			// Verify db
			WaitforObject(appedo_db_verify);
			String addEnterprise = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(addEnterprise)) 
			{
				test.log(LogStatus.PASS, "Enterprise added Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to add enterprise");
			}
			Thread.sleep(1000);
			test = extent.startTest("Unmap Enterprise from DB", "Unmapping enterprise from DB");
			
			// Click on map enterprise
			WaitforObject(appedo_db_mapEnterprise);
			browser.findElement(getObject(appedo_db_mapEnterprise)).click();
			
			// Click remove icon
			WaitforObject(appedo_db_removeEnterprise);
			browser.findElement(getObject(appedo_db_removeEnterprise)).click();
			
			// Click on save
			WaitforObject(appedo_db_saveEnterprise);
			browser.findElement(getObject(appedo_db_saveEnterprise)).click();
			Thread.sleep(1000);
			
			// Verify db
			WaitforObject(appedo_db_verify);
			String deleteEnterprise = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(deleteEnterprise)) 
			{
				test.log(LogStatus.PASS, "Enterprise deleted Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to delete enterprise");
			}
			Thread.sleep(1000);
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

	public void editDB() {
		try {
			test = extent.startTest("DB connector Edition", "Editing DB connector");
			
			// Click on edit icon
			WaitforObject(appedo_editDB);
			browser.findElement(getObject(appedo_editDB)).click();
			
			// Edit details in the fields
			browser.findElement(getObject(appedo_db_txtHost)).click();
			WaitforObject(appedo_db_txtDatabase);
			Thread.sleep(1000);
			browser.findElement(getObject(appedo_db_txtDatabase)).clear();
			browser.findElement(getObject(appedo_db_txtDatabase)).sendKeys("ss_profiler");
			WaitforObject(appedo_db_txtHost);
			browser.findElement(getObject(appedo_db_txtHost)).clear();
			browser.findElement(getObject(appedo_db_txtHost)).sendKeys("35.160.246.188");
			WaitforObject(appedo_db_portNumber);
			browser.findElement(getObject(appedo_db_portNumber)).clear();
			browser.findElement(getObject(appedo_db_portNumber)).sendKeys("5432");
			WaitforObject(appedo_db_txtDBpassword);
			browser.findElement(getObject(appedo_db_txtDBpassword)).clear();
			browser.findElement(getObject(appedo_db_txtDBpassword)).sendKeys("n0#ntry@^pp#d0");
			
			// Save DB connector
			browser.findElement(getObject(appedo_db_btnSave)).click();
			
			// Verify DB connector
			WaitforObject(appedo_db_verify);
			String updateDB = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(updateDB)) 
			{
				test.log(LogStatus.PASS, "Database Connector updated Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to update DB");
			}
			Thread.sleep(2000);
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

	public void deleteDB() {
		try {
			test = extent.startTest("DB connector Deletion", "Deleting DB connector");
			
			// Click on delete icon
			WaitforObject(appedo_deleteDB);
			browser.findElement(getObject(appedo_deleteDB)).click();
			
			// Accept alert 
			browser.switchTo().alert().accept();
			
			// Verify DB connector
			WaitforObject(appedo_db_verify);
			Thread.sleep(2000);
			String deleteDB = browser.findElement(getObject(appedo_db_verify)).getText();
			if (browser.findElement(getObject(appedo_db_verify)).getText().contains(deleteDB)) 
			{
				test.log(LogStatus.PASS, "Database Connector deleted Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to delete Database Connector");
			}
			
			// Click Logout
			WaitforObject(appedo_signout);
			browser.findElement(getObject(appedo_signout)).click();
			
			// Verify Sign out
			WaitforObject(appedo_login_btnlogin);
			if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
			{
				test.log(LogStatus.PASS, "Logout Successful");
			} else {
				test.log(LogStatus.FAIL, "Logout failed");
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

	@AfterMethod
	public void tearDown() throws Exception {
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}

}