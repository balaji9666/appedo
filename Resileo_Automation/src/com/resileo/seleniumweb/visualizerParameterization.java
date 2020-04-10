package com.resileo.seleniumweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.relevantcodes.extentreports.LogStatus;

public class visualizerParameterization extends ReusableMethods {

	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	String parentQuery;
	String childQuery;
	String QueryName;
	String str1;
	String QueryName1;

	@BeforeMethod
	public void setUp() throws Exception {
		InitiateTest("LogPerformancechrome");
		loginNalini();
	}

	@Test
			public void createDB() {
				try {
					test = extent.startTest("Visualizer - Parameterization", "Visualizer - Parameterization Feature");
				
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

	public void addParentQuery() {
		try {
			//test = extent.startTest("Addition of Parent query to DB", "Adding parent query to DB");
			test.log(LogStatus.PASS, "Addition of Parent query to DB");
			// Click on add query
			WaitforObject(appedo_db_addQuery);
			browser.findElement(getObject(appedo_db_addQuery)).click();
			Thread.sleep(7000);

			// Click on select table
			WaitforObject(appedo_db_addQuery_selectTable);
			browser.findElement(getObject(appedo_db_addQuery_selectTable)).sendKeys("module");

			// Select from table
			WaitforObject(appedo_db_addQuery_selectFromTable);
			browser.findElement(getObject(appedo_db_addQuery_selectFromTable)).click();
			Thread.sleep(8000);

			// Click on Filter By
			WaitforObject(appedo_alertSms_filterBy);
			browser.findElement(getObject(appedo_alertSms_filterBy)).click();

			// Click on Select Column
			browser.findElement(getObject(appedo_alertSms_selectColumn)).sendKeys("user");

			// Select a Column
			browser.findElement(getObject(appedo_alertSms_selectAColumn)).click();

			// Click on Filter value Type
			browser.findElement(getObject(appedo_alertSms_filterValueType)).sendKeys("817");

			// Add Filter
			browser.findElement(getObject(appedo_alertSms_addToFilter)).click();

			// Click on group by
			WaitforObject(appedo_db_addQuery_groupBy);
			browser.findElement(getObject(appedo_db_addQuery_groupBy)).click();

			// Click on group column
			Thread.sleep(2000);
			WaitforObject(appedo_db_addQuery_groupColumn);
			browser.findElement(getObject(appedo_db_addQuery_groupColumn)).click();

			// Select a group column
			WaitforObject(appedo_db_addQuery_selectGroupColumn);
			browser.findElement(getObject(appedo_db_addQuery_selectGroupColumn)).click();

			// Click on add to group
			WaitforObject(appedo_db_addQuery_addToGroup);
			browser.findElement(getObject(appedo_db_addQuery_addToGroup)).click();

			// Click on add group
			browser.findElement(getObject(appedo_db_addQuery_addGroup)).click();
			Thread.sleep(5000);

			// Click on group column
			browser.findElement(getObject(appedo_db_addQuery_groupColumn)).click();

			// Add another group
			browser.findElement(getObject(appedo_db_addQuery_addGroupColumn)).click();

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

			// Click on visualization
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			// Select Pie
			WaitforObject(appedo_visualizerChartTypePie);
			browser.findElement(getObject(appedo_visualizerChartTypePie)).click();
			Thread.sleep(1000);

			// Click on run query
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(8000);

			// Click on Configure Column
			browser.findElement(getObject(appedo_db_addQuery_configureColumn)).click();

			// Click on Column Data Type
			WaitforObject(appedo_db_addQuery_configure_columnDataType1);
			browser.findElement(getObject(appedo_db_addQuery_configure_columnDataType1)).click();

			// Select a Data Type
			browser.findElement(getObject(appedo_db_addQuery_configure_selectColumnDataType1)).click();

			// Click on Map Param
			WaitforObject(appedo_db_addQuery_configure_mapParam1);
			browser.findElement(getObject(appedo_db_addQuery_configure_mapParam1)).click();

			// Select a Param
			browser.findElement(getObject(appedo_db_addQuery_configure_selectParam1)).click();

			// Click on Column Data Type
			WaitforObject(appedo_db_addQuery_configure_columnDataType2);
			browser.findElement(getObject(appedo_db_addQuery_configure_columnDataType2)).click();

			// Select a Data Type
			browser.findElement(getObject(appedo_db_addQuery_configure_selectColumnDataType2)).click();

			// Click on Map Param
			WaitforObject(appedo_db_addQuery_configure_mapParam2);
			browser.findElement(getObject(appedo_db_addQuery_configure_mapParam2)).click();

			// Select a Param
			browser.findElement(getObject(appedo_db_addQuery_configure_selectParam2)).click();

			// Click on Column Data Type
			WaitforObject(appedo_db_addQuery_configure_columnDataType3);
			browser.findElement(getObject(appedo_db_addQuery_configure_columnDataType3)).click();

			// Select a Data Type
			browser.findElement(getObject(appedo_db_addQuery_configure_selectColumnDataType3)).click();

			// Click on Apply Changes
			WaitforObject(appedo_db_addQuery_configure_save);
			browser.findElement(getObject(appedo_db_addQuery_configure_save)).click();

			// Click on save icon
			WaitforObject(appedo_db_addQuery_saveQuery);
			browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();

			// Enter details in fields
			String alphabet = "abc";
			parentQuery = "Parent_" + RandomStringUtils.random(4, alphabet);
			browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).sendKeys(parentQuery);
			browser.findElement(getObject(appedo_db_addQuery_txtDesc)).sendKeys("Sample");

			// Click on save button
			WaitforObject(appedo_db_addQuery_btnSave);
			browser.findElement(getObject(appedo_db_addQuery_btnSave)).click();
			Thread.sleep(5000);

			// Verify save query
			WaitforObject(appedo_db_verify_saveQuery);
			String saveQuery = browser.findElement(getObject(appedo_db_verify_saveQuery)).getText();
			if (browser.findElement(getObject(appedo_db_verify_saveQuery)).getText().equalsIgnoreCase(saveQuery)) {
				test.log(LogStatus.PASS, "Successfully saved parent query");
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

	public void addChildQuery() {
		try {
			//test = extent.startTest("Addition of Child query to DB", "Adding child query to DB");
			test.log(LogStatus.PASS, "Addition of Child query to DB");
			// Click on add query
			WaitforObject(appedo_db_addQuery);
			browser.findElement(getObject(appedo_db_addQuery)).click();
			Thread.sleep(7000);

			// Click on Advance SQL
			browser.findElement(getObject(appedo_db_addQuery_advanceSql)).click();

			// Click on SQL Custom Query
			browser.findElement(getObject(appedo_db_addQuery_SqlCustomQuery)).sendKeys(
					"select module_type, count(*) from module_master where lower(module_code) = lower('@@param1@@') AND user_id = @@param2@@ group by module_type");

			// Click on visualization
			Thread.sleep(1000);
			WaitforObject(appedo_visualization_click);
			browser.findElement(getObject(appedo_visualization_click)).click();

			// Select Pie
			WaitforObject(appedo_visualizerChartTypePie);
			browser.findElement(getObject(appedo_visualizerChartTypePie)).click();
			Thread.sleep(1000);

			// Click on run query
			WaitforObject(appedo_db_addQuery_runQuery);
			browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
			Thread.sleep(8000);

			// Enter Param1 value
			WaitforObject(appedo_db_addQuery_txtParam1);
			browser.findElement(getObject(appedo_db_addQuery_txtParam1)).sendKeys("SERVER");

			// Enter Param2 value
			WaitforObject(appedo_db_addQuery_txtParam2);
			browser.findElement(getObject(appedo_db_addQuery_txtParam2)).sendKeys("817");

			// Click on Apply
			browser.findElement(getObject(appedo_db_addQuery_apply)).click();

			// Click on Refresh button
			Thread.sleep(5000);
			browser.findElement(getObject(appedo_db_addQuery_refreshQuery)).click();
			browser.findElement(getObject(appedo_db_addQuery_refreshQuery)).click();
			Thread.sleep(2000);

			// Click on Configure Column
			WaitforObject(appedo_db_addQuery_configureColumn);
			browser.findElement(getObject(appedo_db_addQuery_configureColumn)).click();

			// Click on Map Param
			WaitforObject(appedo_db_addQuery_configure_mapParam1);
			browser.findElement(getObject(appedo_db_addQuery_configure_mapParam1)).click();

			// Select a Param
			browser.findElement(getObject(appedo_db_addQuery_configure_selectParam1)).click();

			// Click on Column Data Type
			WaitforObject(appedo_db_addQuery_configure_columnDataType2);
			browser.findElement(getObject(appedo_db_addQuery_configure_columnDataType2)).click();

			// Select a Data Type
			browser.findElement(getObject(appedo_db_addQuery_configure_selectColumnDataType2)).click();

			// Click on Map Param
			WaitforObject(appedo_db_addQuery_configure_mapParam2);
			browser.findElement(getObject(appedo_db_addQuery_configure_mapParam2)).click();

			// Select a Param
			browser.findElement(getObject(appedo_db_addQuery_configure_selectParam2)).click();

			// Click on Apply Changes
			WaitforObject(appedo_db_addQuery_configure_save);
			browser.findElement(getObject(appedo_db_addQuery_configure_save)).click();

			// Click on save icon
			WaitforObject(appedo_db_addQuery_saveQuery);
			browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();

			// Enter details in fields
			String alphabet = "abc";
			childQuery = "Child_" + RandomStringUtils.random(4, alphabet);
			browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).sendKeys(childQuery);
			browser.findElement(getObject(appedo_db_addQuery_txtDesc)).sendKeys("Sample");

			// Click on save button
			WaitforObject(appedo_db_addQuery_btnSave);
			browser.findElement(getObject(appedo_db_addQuery_btnSave)).click();
			Thread.sleep(5000);

			// Verify save query
			WaitforObject(appedo_db_verify_saveQuery);
			String saveQuery = browser.findElement(getObject(appedo_db_verify_saveQuery)).getText();
			if (browser.findElement(getObject(appedo_db_verify_saveQuery)).getText().equalsIgnoreCase(saveQuery)) {
				test.log(LogStatus.PASS, "Successfully saved child query");
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

	public void mapChartid() {
		try {
			//test = extent.startTest("Map ID of Child Query to Parent Query", "Mapping ID of child query to Parent Query");

			// Click on view queries
			Thread.sleep(2000);
			WaitforObject(appedo_db_viewQueries);
			browser.findElement(getObject(appedo_db_viewQueries)).click();
			Thread.sleep(3000);
			List<WebElement> table = browser.findElements(By.xpath("//table/tbody/tr"));
			int totalrows = table.size();
			for (int i = 0; i < totalrows; i++) {
				QueryName = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (i + 1) + "] /td[3]")).getText()
						.toString();
				if (QueryName.equalsIgnoreCase(childQuery)) {
					browser.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).click();
					Thread.sleep(12000);

					// Get ID of Child Query
					String idValue = browser.findElement(getObject(appedo_db_editGetid)).getText().toString();
					int id = Integer.parseInt(idValue.split(" ")[9]);
					str1 = Integer.toString(id);
					test.log(LogStatus.PASS, "Getting Child Query id " + str1);
					Thread.sleep(2000);
					browser.navigate().back();

					// Click on view queries
					Thread.sleep(4000);
					WaitforObject(appedo_db_viewQueries);
					browser.findElement(getObject(appedo_db_viewQueries)).click();
					List<WebElement> table1 = browser.findElements(By.xpath("//table/tbody/tr"));
					int totalrows1 = table1.size();
					for (int j = 0; j < totalrows1; j++) {
						QueryName1 = browser.findElement(By.xpath("//table[1]/tbody[1]/tr[" + (j + 1) + "] /td[3]"))
								.getText().toString();
						if (QueryName1.equalsIgnoreCase(parentQuery)) {
							browser.findElement(By.xpath("//table/tbody/tr[" + (j + 1) + "]/td[1]")).click();
							Thread.sleep(15000);
							
							// Click on Map drill down chart ID
							Thread.sleep(2000);
							browser.findElement(getObject(appedo_db_editMapDrilldownChartId)).click();
							browser.findElement(getObject(appedo_db_editMapDrilldownChartId)).sendKeys(str1);
							
							// Click on run query
							WaitforObject(appedo_db_addQuery_runQuery);
							browser.findElement(getObject(appedo_db_addQuery_runQuery)).click();
							Thread.sleep(8000);
							
							// Click on Add to my chart
							WaitforObject(appedo_db_viewQuery_addToMyChart);
							browser.findElement(getObject(appedo_db_viewQuery_addToMyChart)).click();
							
							// Click on My dash board drop down
							Thread.sleep(3000);
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
							if (browser.findElement(getObject(appedo_db_verify_saveQuery)).getText()
									.equalsIgnoreCase(saveQuery)) {
								test.log(LogStatus.PASS, "Successfully Added");
							} else {
								test.log(LogStatus.FAIL, "Failed to save Query");
							}

							// Click on save icon
							WaitforObject(appedo_db_addQuery_saveQuery);
							browser.findElement(getObject(appedo_db_addQuery_saveQuery)).click();

							// Enter details in fields
							String alphabet = "abc";
							parentQuery = "Parent_" + RandomStringUtils.random(4, alphabet);
							browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).clear();
							browser.findElement(getObject(appedo_db_addQuery_txtQueryName)).sendKeys(parentQuery);
							browser.findElement(getObject(appedo_db_addQuery_txtDesc)).clear();
							browser.findElement(getObject(appedo_db_addQuery_txtDesc)).sendKeys("Sample");

							// Click on save button
							WaitforObject(appedo_db_addQuery_btnSave);
							browser.findElement(getObject(appedo_db_addQuery_btnSave)).click();
							Thread.sleep(5000);

							// Verify save query
							WaitforObject(appedo_db_verify_saveQuery);
							saveQuery = browser.findElement(getObject(appedo_db_verify_saveQuery)).getText();
							if (browser.findElement(getObject(appedo_db_verify_saveQuery)).getText()
									.equalsIgnoreCase(saveQuery)) {
								test.log(LogStatus.PASS, "Successfully saved parent query");
							} else {
								test.log(LogStatus.FAIL, "Failed to save Query");
							}
						}
					}				
				}										
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
	
	public void RemoveChart() {
		try {
			
			Thread.sleep(8000);
			//----				// Click close icon
			WaitforObject(appedo_db_addQuery_close);
			browser.findElement(getObject(appedo_db_addQuery_close)).click();
			//test = extent.startTest("View added chart in Dash Board", "Viewing added chart in Dash Board");
			
			// Click on toggle menu
			WaitforObject(appedo_toggleMenu);
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_toggleMenu)).click();
			browser.findElement(getObject(appedo_toggleMenu)).click();
			
			// Click on Dash Board
			browser.findElement(getObject(appedo_link_dashboard)).click();
			Thread.sleep(3000);
			
			// Click on my dash board drop down
			browser.findElement(getObject(appedo_dropdown_myDashboard)).click();
			
			// Select chart name
			browser.findElement(getObject(appedo_select_chart_added_dashboard)).click();
			Thread.sleep(7000);
			
			// Verify added chart is displayed
			String getdashboardname = browser.findElement(getObject(appedo_db_verifyAddedChart)).getText();
			Thread.sleep(2000);
			if (getdashboardname.contains("custom")) 
			{
				test.log(LogStatus.PASS, "Added chart is updated in existing dashboard");
			} else {
				test.log(LogStatus.FAIL, "Added chart is not updated in existing dashboard");
			}
			Thread.sleep(2000);
			//test = extent.startTest("Remove chart from Dash Board", "Removing chart from Dash Board");
			
			// Click on Remove
			WaitforObject(appedo_db_removeChart);
			browser.findElement(getObject(appedo_db_removeChart)).click();
			
			// Confirmation of alert
			browser.switchTo().alert().accept();

			// Verify Dash board Deletion
			Thread.sleep(7000);
			//WaitforObject(appedo_dashboard_verifyDelete);
			//String Msg3 = browser.findElement(getObject(appedo_dashboard_verifyDelete)).getText();
			if (browser.findElement(getObject(appedo_systemMetrics_verifyGraphsNetwork)).isDisplayed()) 
			//if(browser.findElement(getObject(appedo_dashboard_verifyDelete)).getText().contains(Msg3)) 
			{
				test.log(LogStatus.PASS, "Dashboard Deletion :  Successfully deleted");
			} else {
				test.log(LogStatus.FAIL, "Dashboard Deletion failed");
			}
			
			// Click on toggle menu
			WaitforObject(appedo_toggleMenu);
			Thread.sleep(3000);
			browser.findElement(getObject(appedo_toggleMenu)).click();
			browser.findElement(getObject(appedo_toggleMenu)).click();
			
			// Click on visualizer
			WaitforObject(appedo_link_Visualizer);
			browser.findElement(getObject(appedo_link_Visualizer)).click();
			
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
	
	}

}