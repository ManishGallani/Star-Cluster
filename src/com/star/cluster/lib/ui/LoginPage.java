package com.star.cluster.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;	
	}
	
	public void waitForPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getUsernameTextbox()));
		wait.until(ExpectedConditions.visibilityOf(getpasswrodTextbox()));
		wait.until(ExpectedConditions.visibilityOf(getLoginButton()));
		wait.until(ExpectedConditions.visibilityOf(geterrormessage()));

	}
	
	public WebElement getUsernameTextbox()
	{
		try {
					
			return driver.findElement(By.name("username"));
		   }
		
		catch (Exception e)
		{
			return null;
			
		}
	}
	
	public WebElement getpasswrodTextbox()
	{
		try {
					
			return driver.findElement(By.name("pwd"));
			
		    }
		
		catch (Exception e)
		{
			return null;
			
		}
}
	
	public WebElement getLoginButton()
	{
		try {
					
			return driver.findElement(By.xpath("//div[text()='Login ']"));
		   }
		catch (Exception e)
		{
			return null;
			
		}
	}
	public WebElement geterrormessage()
	{
		try {
					
			return driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']"));
		   }
		catch (Exception e)
		{
			return null;
			
		}
	}
	
	
}
