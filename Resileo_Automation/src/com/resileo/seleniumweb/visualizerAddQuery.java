package com.resileo.seleniumweb;

import org.junit.*;
import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class visualizerAddQuery extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String queryName;

	@Before
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
			WaitforObject(appedo_verifyLogin);
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
			
			// validation of all fields
			browser.findElement(getObject(appedo_db_txtHost)).click();
			if (browser.findElement(getObject(appedo_db_validateEngineName)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Engine name validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Engine name validation is failed ");
			}
			browser.findElement(getObject(appedo_db_txtDBuser)).click();
			WaitforObject(appedo_db_validateHost);
			if (browser.findElement(getObject(appedo_db_validateHost)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Host validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Host validation is failed");
			}
			browser.findElement(getObject(appedo_db_txtDatabase)).click();
			WaitforObject(appedo_db_validatetxtDBUser);
			if (browser.findElement(getObject(appedo_db_validatetxtDBUser)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "DB User validation is successful");
			} else {
				test.log(LogStatus.FAIL, "DB User validation is failed");
			}
			browser.findElement(getObject(appedo_db_portNumber)).click();
			WaitforObject(appedo_db_validatetxtDatabase);
			if (browser.findElement(getObject(appedo_db_validatetxtDatabase)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Database validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Database validation is failed");
			}
			browser.findElement(getObject(appedo_db_txtDBpassword)).click();
			WaitforObject(appedo_db_validatePort);
			if (browser.findElement(getObject(appedo_db_validatePort)).getText().equalsIgnoreCase("You must enter a value")) 
			{
				test.log(LogStatus.PASS, "Port validation is successful");
			} else {
				test.log(LogStatus.FAIL, "Port validation is failed");
			}
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

	public void addQueryToDB() {
		try {
			test = extent.startTest("Addition of a query to DB", "Adding query to DB");
			
			// Click on add query
			WaitforObject(appedo_db_addQuery);
			browser.findElement(getObject(appedo_db_addQuery)).click();
			Thread.sleep(12000);
			
			// Click on select table
			WaitforObject(appedo_db_addQuery_selectTable);
			browser.findElement(getObject(appedo_db_addQuery_selectTable)).sendKeys("module");
			
			// Select from table
			WaitforObject(appedo_db_addQuery_selectFromTable);
			browser.findElement(getObject(appedo_db_addQuery_selectFromTable)).click();
			Thread.sleep(10000);
			
			// Click on group by
			WaitforObject(appedo_db_addQuery_groupBy);
			browser.findElement(getObject(appedo_db_addQuery_groupBy)).click();
			
			// Click on group column
			browser.findElement(getObject(appedo_db_addQuery_groupColumn)).click();
			
			// Select a group column
			WaitforObject(appedo_db_addQuery_selectGroupColumn);
			browser.findElement(getObject(appedo_db_addQuery_selectGroupColumn)).click();
			
			// Click on add to group
			WaitforObject(appedo_db_addQuery_addToGroup);
			browser.findElement(getObject(appedo_db_addQuery_addToGroup)).click();
			
			// Click on view
			WaitforObject(appedo_db_addQuery_view);
			browser.findElement(getObject(appedo_db_addQuery_view)).click();
			
			// Click on select aggregator
			WaitforObject(appedo_db_addQuery_aggregator);
			browser.findElement(getObject(appedo_db_addQuery_aggregator)).click();
			
			// Select an aggregator
			browser.findElement(getObject(appedo_db_addQuery_selectAggregator)).click();
			
			// Click on add to column
			browser.findElement(getObject(appedo_db_addQuery_addToColumn)).click();
			
			// Click on Order By
			WaitforObject(appedo_db_addQuery_orderBy);
			browser.findElement(getObject(appedo_db_addQuery_orderBy)).click();
			
			// Click on Select Column
			browser.findElement(getObject(appedo_db_addQuery_orderBy_selectColumn)).click();
			
			// Select a Column
			browser.findElement(getObject(appedo_db_addQuery_orderBy_selectAColumn)).click();
			
			// Click on Add to Order By
			browser.findElement(getObject(appedo_db_addQuery_addToOrderBy)).click();
			
			// Click on run query
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(8000);
			
			// Verify add query
			if (browser.findElement(getObject(appedo_db_verify_addQuery)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Query added successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to add Query");
			}
			
			// Click on save icon
			WaitforObject(appedo_db_addQuery_saveQuery);
			browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();
			
			// Enter details in fields
			String alphabet = "abc";
			queryName = "Query_" + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).sendKeys(queryName);
			browser.findElement(getObject(appedo_db_addQuery_txtDesc)).sendKeys("Sample");
			
			// Click on save button
			WaitforObject(appedo_db_addQuery_btnSave);
			browser.findElement(getObject(appedo_db_addQuery_btnSave)).click();
			Thread.sleep(5000);
			
			// Verify save query
			WaitforObject(appedo_db_verify_saveQuery);
			String saveQuery = browser.findElement(getObject(appedo_db_verify_saveQuery)).getText();
			if (browser.findElement(getObject(appedo_db_verify_saveQuery)).getText().equalsIgnoreCase(saveQuery)) 
			{
				test.log(LogStatus.PASS, "Successfully saved the query");
			} else {
				test.log(LogStatus.FAIL, "Failed to save Query");
			}
			
			// Click close icon
			WaitforObject(appedo_db_addQuery_close);
			browser.findElement(getObject(appedo_db_addQuery_close)).click();
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
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			fail(verificationErrorString);
		}
	}

}