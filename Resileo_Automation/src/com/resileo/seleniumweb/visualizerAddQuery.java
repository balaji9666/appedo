package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class visualizerAddQuery extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	
	String queryName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	
	public void createDB() {
		try {
			test = extent.startTest("Visualizer - Add Query", "Adding query to DB");
		
			// Click on visualizer
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();
			
			// Click on add db icon
			WaitforObject(appedo_addDB);
			browser.findElement(getObject(appedo_addDB)).click();
						
			// Enter values in all fields
			browser.findElement(getObject(appedo_db_txtEngineName)).click();
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

	public void addQueryToDB() {
		try {
			//test = extent.startTest("Addition of a query to DB", "Adding query to DB");
			
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

	
	public void addQueryToDB2() {
		try {
			//test = extent.startTest("Addition of a query to DB", "Adding query to DB");
			
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
				test.log(LogStatus.PASS, "Second Query added successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to add Second Query");
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
				test.log(LogStatus.PASS, "Successfully saved the second query");
			} else {
				test.log(LogStatus.FAIL, "Failed to save the seconf Query");
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
	
	@AfterMethod
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
	}

}