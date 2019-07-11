package com.star.cluster.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Preconditions;
import com.star.cluster.config.CreateDriver;

public class TestSampleAPI {

WebDriver driver ;
@BeforeMethod
public void Preconditions()
{
	driver = CreateDriver.getBrowserInstance();
}

@AfterMethod
public void PostConditions()
{
	driver.close();
}
	
@Test
public void testSample()
{

	String actualTitle = driver.getTitle();
	String expectedTitle = "actTIME-Login";
	Assert.assertEquals(actualTitle, expectedTitle);
	
}



}
