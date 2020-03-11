package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class visualizerViewQuery extends ReusableMethods {
	
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();


	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
	public void viewQueriesEdit() {
		try {
			test = extent.startTest("Visualizer view Queries Edit", "Edit Visualizer view Queries");

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

			// Click on view queries
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();

			// Click on Edit icon
			WaitforObject(appedo_db_editViewQueries);
			browser.findElement(getObject(appedo_db_editViewQueries)).click();
			Thread.sleep(5000);
			
			// Remove Order By
			WaitforObject(appedo_db_removeOrderBy);
			browser.findElement(getObject(appedo_db_removeOrderBy)).click();
			
			// Click on Order By
			WaitforObject(appedo_db_addQuery_orderBy);
			browser.findElement(getObject(appedo_db_addQuery_orderBy)).click();

			// Click on Select Column
			browser.findElement(getObject(appedo_db_addQuery_orderBy_selectColumn)).click();
			
			// Select a Column
			browser.findElement(getObject(appedo_db_selectOrderBy)).click();
			Thread.sleep(3000);
			
			// Click on Sort By
			WaitforObject(appedo_db_orderBy_sortBy);
			browser.findElement(getObject(appedo_db_orderBy_sortBy)).click();
			
			// Select Desc
			browser.findElement(getObject(appedo_db_orderBy_desc)).click();
			
			// Click on Add to Order By
			browser.findElement(getObject(appedo_db_addQuery_addToOrderBy)).click();
			
			// Click on run query
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(8000);
			
			// Click on chart type to change
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			// click on Chart type to stamp type
			WaitforObject(appedo_visualizerChartTypeStamp);
			browser.findElement(getObject(appedo_visualizerChartTypeStamp)).click();
			Thread.sleep(1000);

			// Verify stamp visualization type
			WaitforObject(appedo_chartTypeStampValidation);
			if (browser.findElement(getObject(appedo_chartTypeStampValidation)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type : Stamp");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query");
			}

			// click on Chart type to Pie type
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			WaitforObject(appedo_visualizerChartTypePie);
			browser.findElement(getObject(appedo_visualizerChartTypePie)).click();
			Thread.sleep(1000);

			// Verify refresh query
			WaitforObject(appedo_db_addQuery_verifyRefreshQuery);
			if (browser.findElement(getObject(appedo_db_addQuery_verifyRefreshQuery)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type:Pie");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query ");
			}

			// click on Chart type to Pie3d type
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			WaitforObject(appedo_visualizerChartTypePie3d);
			browser.findElement(getObject(appedo_visualizerChartTypePie3d)).click();

			// Verify refresh query
			WaitforObject(appedo_db_addQuery_verifyRefreshQuery);
			if (browser.findElement(getObject(appedo_db_addQuery_verifyRefreshQuery)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type : Pie3d");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query Pie3d");
			}
			// click on Chart type to Donut type
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			WaitforObject(appedo_visualizerChartTypeDonut);
			browser.findElement(getObject(appedo_visualizerChartTypeDonut)).click();
			// Verify refresh query
			WaitforObject(appedo_chartTypeDonutValidation);
			if (browser.findElement(getObject(appedo_chartTypeDonutValidation)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type : Donut");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query");
			}

			// click on Chart type to Donut3d type
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			WaitforObject(appedo_visualizerChartTypeDonut3d);
			browser.findElement(getObject(appedo_visualizerChartTypeDonut3d)).click();
			
			// Verify refresh query
			WaitforObject(appedo_chartTypeDonut3dValidation);
			if (browser.findElement(getObject(appedo_chartTypeDonut3dValidation)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type : Donut3d");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query");
			}

			// click on Chart type to H bar type
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			WaitforObject(appedo_visualizerChartTypeHbar);
			browser.findElement(getObject(appedo_visualizerChartTypeHbar)).click();
			
			// Verify refresh query
			WaitforObject(appedo_chartTypeHbarValidation);
			if (browser.findElement(getObject(appedo_chartTypeHbarValidation)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type : Hbar");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query");
			}

			// click on Chart type to Other type
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			WaitforObject(appedo_visualizerChartTypeOthers);
			browser.findElement(getObject(appedo_visualizerChartTypeOthers)).click();
			
			// Verify refresh query
			WaitforObject(appedo_chartTypeOthersValidation);
			if (browser.findElement(getObject(appedo_chartTypeOthersValidation)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "Successfully Refreshed the Query view type : Others");
			} else {
				test.log(LogStatus.FAIL, "Failed to refresh Query");
			}
			browser.navigate().back();
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

	public void viewQueriesDelete() {
		try {
			test = extent.startTest("Visualizer view Queries Delete", "Visualizer view Queries Delete");
			
			// Click on view queries
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();

			// Click on Delete icon in view queries
			WaitforObject(appedo_db_deleteViewQueries);
			browser.findElement(getObject(appedo_db_deleteViewQueries)).click();

			browser.switchTo().alert().accept();

			// Verify Delete operation
			WaitforObject(appedo_db_deleteViewQueries);
			if (browser.findElement(getObject(appedo_db_deleteViewQueries)).isDisplayed()) 
			{
				test.log(LogStatus.PASS, "View Queries Deleted Successfully");
			} else {
				test.log(LogStatus.FAIL, "Failed to delete query");
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
	public void logoutAppedo() throws Exception {
		logout();
		WaitforObject(appedo_login_btnlogin);
		
		// Verify Signout
		if (browser.findElement(getObject(appedo_login_btnlogin)).getText().equalsIgnoreCase("Login")) 
		{
			test.log(LogStatus.PASS, "Logout Successful");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
		extent.endTest(test);
		extent.flush();
		browser.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equalsIgnoreCase(verificationErrorString)) 
		{
			Assert.fail(verificationErrorString);
		}
	}
}
