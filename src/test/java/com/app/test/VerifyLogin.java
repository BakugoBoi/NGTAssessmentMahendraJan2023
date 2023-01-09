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

import com.app.pages.LoginPage;

public class VerifyLogin{
	
	WebDriver driver;
	public Properties prop;
	LoginPage loginPage;
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
		loginPage=new LoginPage(driver);
	}
  @Test
  public void verifyLogin() throws Exception {
	  
	  loginPage.enterDetails();
	  Thread.sleep(5000);
	  Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Profile']")).isDisplayed());
	  String actTitle=driver.getTitle();
	  Assert.assertEquals(actTitle, prop.getProperty("expTitle"));
	  
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
}
