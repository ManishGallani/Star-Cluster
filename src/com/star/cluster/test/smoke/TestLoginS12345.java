package com.star.cluster.test.smoke;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.star.cluster.config.CreateDriver;
import com.star.cluster.lib.ui.LoginPage;
import com.star.cluster.lib.utils.DataHandlers;

public class TestLoginS12345 {

	WebDriver driver ;
	LoginPage login;
	@BeforeMethod
	public void Preconditions()
	{
		driver = CreateDriver.getBrowserInstance();
		login = new LoginPage(driver);
	}

	@AfterMethod
	public void PostConditions()
	{
		driver.close();
	}

	
	@Test
	public void testInvalidLoginTC1234567()
	{
		String un = DataHandlers.getDatafromExcel("./Test-Data/data.xlsx", "TC1234567",  1, 0);
		String pwd = DataHandlers.getDatafromExcel("./Test-Data/data.xlsx", "TC1234567", 1, 1);
		String expectedErrorMsg = DataHandlers.getDatafromExcel("./Test-Data/data.xlsx", "TC1234567", 1, 2);
		System.out.println(un + pwd);
		login.waitForPageToLoad();
		String beforeTitle = driver.getTitle();
		
		login.getUsernameTextbox().sendKeys(un);
		login.getpasswrodTextbox().sendKeys(pwd);
		
		login.getLoginButton().click();
		String actualErrormsg = login.geterrormessage().getText();
		Assert.assertEquals(actualErrormsg, expectedErrorMsg);
		
		String afterTitle = driver.getTitle();
		Assert.assertEquals(beforeTitle, afterTitle);

		
	}
}
