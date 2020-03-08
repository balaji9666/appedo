package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class visualizerNormalDrillDown extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	ExtentReports extent = new ExtentReports("allclass.html", false);
	ExtentTest test;
	String childqueryName;
	String EditName;
	String EditName2;
	String parentqueryName;
	String str1;
	String chartName;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNagas();
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

	public void addParentQueryToDB() {
		try {
			test = extent.startTest("Add parent query to DB", "Adding parent query to DB");

			// Click on add query
			WaitforObject(appedo_db_addQuery);
			browser.findElement(getObject(appedo_db_addQuery)).click();
			Thread.sleep(10000);

			// Click on select table
			WaitforObject(appedo_db_addQuery_selectTable);
			browser.findElement(getObject(appedo_db_addQuery_selectTable)).sendKeys("module");

			// Select from table
			WaitforObject(appedo_db_addQuery_selectFromTable);
			browser.findElement(getObject(appedo_db_addQuery_selectFromTable)).click();
			Thread.sleep(10000);

			// click on FilterBy
			WaitforObject(appedo_db_addQuery_filterBy);
			browser.findElement(getObject(appedo_db_addQuery_filterBy)).click();

			// Select column name
			Thread.sleep(5000);
			WaitforObject(appedo_db_addQuery_SelcolName);
			browser.findElement(getObject(appedo_db_addQuery_SelcolName)).click();
			browser.findElement(getObject(appedo_db_addQuery_SelcolName)).sendKeys("user");
			browser.findElement(getObject(appedo_db_addQuery_selUserID)).click();
			browser.findElement(getObject(appedo_db_addQuery_filVal)).sendKeys("816");
			// Click on Add Save button
			browser.findElement(getObject(appedo_db_BtnaddtoFilter)).click();

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

			// Click on run query
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(2000);

			// Click on chart type to change
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();
			Thread.sleep(1000);
			
			// Selct Chart Type
			WaitforObject(appedo_visualizerChartTypePie);
			browser.findElement(getObject(appedo_visualizerChartTypePie)).click();
			Thread.sleep(1000);

			// Click on save icon
			WaitforObject(appedo_db_addQuery_saveQuery);
			browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();

			// Enter details in fields
			String alphabet = "abc";
			parentqueryName = "ParentQuery_" + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).sendKeys(parentqueryName);
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

	public void addChildQueryToDB() {
		try {
			test = extent.startTest("Add child query to DB", "Adding child query to DB");

			// Click on add query
			Thread.sleep(3000);
			WaitforObject(appedo_db_addQuery);
			browser.findElement(getObject(appedo_db_addQuery)).click();
			Thread.sleep(10000);

			// Click on select table
			WaitforObject(appedo_db_addQuery_selectTable);
			browser.findElement(getObject(appedo_db_addQuery_selectTable)).sendKeys("module");

			// Select from table
			WaitforObject(appedo_db_addQuery_selectFromTable);
			browser.findElement(getObject(appedo_db_addQuery_selectFromTable)).click();
			Thread.sleep(10000);

			// click on FilterBy
			WaitforObject(appedo_db_addQuery_filterBy);
			browser.findElement(getObject(appedo_db_addQuery_filterBy)).click();

			// Select column name
			Thread.sleep(5000);
			WaitforObject(appedo_db_addQuery_SelcolName);
			browser.findElement(getObject(appedo_db_addQuery_SelcolName)).click();
			browser.findElement(getObject(appedo_db_addQuery_SelcolName)).sendKeys("module");
			browser.findElement(getObject(appedo_db_filBySelModulecode)).click();
			browser.findElement(getObject(appedo_db_addQuery_filVal)).sendKeys("RUM");

			// Click on Add Save button
			browser.findElement(getObject(appedo_db_BtnaddtoFilter)).click();

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

			// Click on run query
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(2000);

			// Click on chart type to change
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();
			Thread.sleep(1000);
			
			// Select Chart Type
			WaitforObject(appedo_visualizerChartTypePie3d);
			browser.findElement(getObject(appedo_visualizerChartTypePie3d)).click();

			// Click on save icon
			WaitforObject(appedo_db_addQuery_saveQuery);
			browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();

			// Enter details in fields
			String alphabet = "abcfguykyil";
			childqueryName = "ChildQuery_" + RandomStringUtils.random(8, alphabet);
			browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).sendKeys(childqueryName);
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

	public void mapQueryToDB() {
		try {
			test = extent.startTest("Getting child query id", "Getting child query id");
			
			// Click on view queries
			Thread.sleep(2000);
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();
			Thread.sleep(4000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) 
			{
				EditName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[3]")).getText().toString();
				if (EditName.equalsIgnoreCase(childqueryName)) 
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					Thread.sleep(10000);

					// Get ID of Child Query
					String idValue = browser.findElement(getObject(appedo_db_editGetid)).getText().toString();
					int id = Integer.parseInt(idValue.split(" ")[9]);
					str1 = Integer.toString(id);
					test.log(LogStatus.PASS, "Getting Child Query id " + str1);
					Thread.sleep(2000);
					browser.navigate().back();
					Thread.sleep(2000);
					break;
				}
				extent.endTest(test);
				extent.flush();
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

	public void maptoParentQueryToDB() {
		try {
			test = extent.startTest("Mapping child query id ", "Mapping child query id into Parent");
			
			// Click on View Queries
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();
			Thread.sleep(2000);
			browser.findElement((By.xpath("//table/tbody/tr[1]/td[3]"))).click();
			List<WebElement> tables = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows2 = tables.size();
			for (int j = 0; j < totalrows2; j++) 
			{
				EditName2 = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (j + 1) + "] /td[3]")).getText().toString();
				if (EditName2.equalsIgnoreCase(parentqueryName)) 
				{
					browser.findElement(By.xpath("//table/tbody/tr[" + (j + 1) + "]/td[1]")).click();
					test.log(LogStatus.PASS, "Mapping the Child chart id in Parent Query");
					Thread.sleep(7000);
					
					// Enter Chart ID 
					browser.findElement(getObject(appedo_db_editMapDrilldownChartId)).click();
					browser.findElement(getObject(appedo_db_editMapDrilldownChartId)).sendKeys(str1);
					
					// Click on run query
					Thread.sleep(2000);
					WaitforObject(appedo_db_addQuery_runQuery);
					browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();

					// Click on save icon
					Thread.sleep(3000);
					WaitforObject(appedo_db_addQuery_saveQuery);
					browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();

					// Enter details in fields
					browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).click();
					browser.findElement(getObject(appedo_db_addQuery_txtDesc)).click();

					// Click on save button
					WaitforObject(appedo_db_addQuery_btnSave);
					browser.findElement(getObject(appedo_db_addQuery_btnSave)).click();
					Thread.sleep(2000);

					// Add to charts
					WaitforObject(appedo_db_editAddtochart);
					browser.findElement(getObject(appedo_db_editAddtochart)).click();

					// Click on My Dash Board Drop Down
					Thread.sleep(1000);
					WaitforObject(appedo_myDashboardDropdown);
					browser.findElement(getObject(appedo_myDashboardDropdown)).click();

					// Select My dash board Appedo2
					Thread.sleep(1000);
					WaitforObject(appedo_selectMyDashboard);
					browser.findElement(getObject(appedo_selectMyDashboard)).click();

					// Click on Save
					browser.findElement(getObject(appedo_db_editBtnSave)).click();
					
					// Verify save query
					WaitforObject(appedo_db_verify_saveQuery);
					String saveQuery = browser.findElement(getObject(appedo_db_verify_saveQuery)).getText();
					if (browser.findElement(getObject(appedo_db_verify_saveQuery)).getText().equalsIgnoreCase(saveQuery)) 
					{
						test.log(LogStatus.PASS, "Successfully Added");
					} else {
						test.log(LogStatus.FAIL, "Failed to save Query");
					}
					Thread.sleep(2000);
					
					// Click close icon
					WaitforObject(appedo_db_addQuery_close);
					browser.findElement(getObject(appedo_db_addQuery_close)).click();
					break;
				}
				extent.endTest(test);
				extent.flush();
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

	@AfterMethod
	public void logoutModule() throws Exception {

		// Click on sign out
		Thread.sleep(2000);
		logout();

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
		browser.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}