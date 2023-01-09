package com.app.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.base.BaseClass;

public class LoginPage extends BaseClass{

	WebDriver driver;
	public Properties prop;
	
	public void loadProperties() throws Exception
	{
		prop=new Properties();
		
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
		
		FileInputStream fis = new FileInputStream(propFile);
		
		prop.load(fis);
	}
	
	public LoginPage(WebDriver driver) throws Exception
	{
		loadProperties();
		this.driver=driver;
	}
	
	public void enterDetails() throws Exception
	{
		driver.findElement(By.id("mobileNumberPass")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		Thread.sleep(34000);
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		
		
	}
	/*public void checkForlogin() throws Exception
	{
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Profile']")).isDisplayed());
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, prop.getProperty("expTitle"));
	}*/
}
