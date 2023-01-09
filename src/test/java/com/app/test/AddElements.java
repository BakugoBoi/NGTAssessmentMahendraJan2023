package com.app.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.AddElementsPage;
import com.app.pages.LoginPage;

public class AddElements {
	
	WebDriver driver;
	AddElementsPage addElementsPage;
	public Properties prop;
	public void loadProperties() throws Exception
	{
		prop=new Properties();
		
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties");
		
		FileInputStream fis = new FileInputStream(propFile);
		
		prop.load(fis);
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		loadProperties();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url1"));
		addElementsPage=new AddElementsPage(driver);
	}
  @Test
  public void verifyAddtoCart() throws Exception {
	  
	  //addElementsPage.enterDetails();
	  addElementsPage.checkForBag();
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='itemContainer-base-brand']")).isDisplayed());
  
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
}
