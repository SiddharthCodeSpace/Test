package com.automation.Bisa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Library {
	
	public static WebDriver d;
	
	public static void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", "D:\\myCodeSpace\\Bisa\\resources\\geckodriver.exe");
			d=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\myCodeSpace\\Bisa\\resources\\chromedriver.exe");
			d=new ChromeDriver();	
		}
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().deleteAllCookies();
	}
}
