package com.star.cluster.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.star.cluster.lib.utils.DataHandlers;

public class CreateDriver {

	public static WebDriver getBrowserInstance ()
	{
		WebDriver driver = null;
		String browserInfo = DataHandlers.getDatafromProperties("./Config-Data/Configuration_Properties", "browser");
		String url = DataHandlers.getDatafromProperties("./Config-Data/Configuration_Properties", "url");
		if (browserInfo.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser-server/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserInfo.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.firefox.driver", "");
			driver = new FirefoxDriver();
		}
		else if (browserInfo.equalsIgnoreCase("ie"))
		{
			//System.setProperty("webdriver.firefox.driver", "");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (url.equalsIgnoreCase("prod"))
		{
			driver.get(DataHandlers.getDatafromProperties("./Config-Data/Configuration_Properties", "prod"));
		}
		else
		{
			driver.get(DataHandlers.getDatafromProperties("./Config-Data/Configuration_Properties", "test"));

		}
		
		return driver;
	}
	
}
