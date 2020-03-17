package com.resileo.seleniumweb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestNGCustomReportListener implements IReporter{
	
	private ExtentReports extent;
	
	 @Override
	    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNG.html", true);
	  
	        for (ISuite suite : suites) {
	            Map<String, ISuiteResult> result = suite.getResults();
	  
	            for (ISuiteResult r : result.values()) {
	                ITestContext context = r.getTestContext();
	  
	                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
	                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
	                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
	            }
	        }
	  
	        extent.flush();
	        extent.close();
	    }
	  
	    private void buildTestNodes(IResultMap tests, LogStatus status) {
	        ExtentTest test;
	  
	        if (tests.size() > 0) {
	            for (ITestResult result : tests.getAllResults()) {
	                test = extent.startTest(result.getMethod().getMethodName());
	  
	           //     test.getTest().startedTime = getTime(result.getStartMillis());
	           //     test.getTest().endedTime = getTime(result.getEndMillis());
	  
	                for (String group : result.getMethod().getGroups())
	                    test.assignCategory(group);
	  
	                String message = "Test " + status.toString().toLowerCase() + "ed";
	  
	                if (result.getThrowable() != null)
	                    message = result.getThrowable().getMessage();
	  
	                test.log(status, message);
	  
	                extent.endTest(test);
	            }
	        }
	    }
	  
	    private Date getTime(long millis) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(millis);
	        return calendar.getTime();        
	    }
    
}
