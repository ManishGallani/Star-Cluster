package com.star.cluster.test.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.star.cluster.config.CreateDriver;
import com.star.cluster.lib.ui.LoginPage;
import com.star.cluster.lib.ui.LoginPageError;

public class TestEnvErrorT12346 {
  
	WebDriver driver ;
	LoginPageError login ;
	
	@BeforeMethod
	public void Preconditions()
	{
		driver = CreateDriver.getBrowserInstance();
		login = new LoginPageError(driver);
	}

	@AfterMethod
	public void PostConditions()
	{
		driver.close();
	}
	
	@Test
  public void testEnvErrorLoginTC123456() {
  
	login.waitForPageToLoad();
	String expText = "We are currently performing maintenance";
	String actualText = login.getenverror().getText();
	Assert.assertEquals(expText, actualText ,"Env Error");
	
	}
}
