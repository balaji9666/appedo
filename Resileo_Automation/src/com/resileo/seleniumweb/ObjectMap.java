package com.resileo.seleniumweb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


public class ObjectMap{
	
	
public By getObject(String strElement) throws Exception {
	Logger log = Logger.getLogger("Resileo");

		
		// retrieve the specified object from the object list
		String locator = strElement;
		
		// extract the locator type and value from the object
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		// for testing and debugging purposes
		log.debug("Performing Operation on'" + strElement + "' with attribute type '" + locatorType + "' and attribute value '" + locatorValue);
		
		// return a instance of the By class based on the type of the locator
		// this By can be used by the browser object in the actual test
		if(locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.className(locatorValue);
		else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if(locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}


 

 
}