package com.star.cluster.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageError {

	WebDriver driver;
	public LoginPageError (WebDriver driver)
	{
		this.driver = driver;	
	}
	
	public void waitForPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getenverror()));

	}
	public WebElement getenverror() {
		try {
			
			return driver.findElement(By.xpath("//h1[contains(text(),' We are currently performing maintenance')]"));
		   }
		catch (Exception e)
		{
			return null;
			
		}
		
	}
}
