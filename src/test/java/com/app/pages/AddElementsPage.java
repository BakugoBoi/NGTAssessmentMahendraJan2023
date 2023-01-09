package com.app.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddElementsPage {

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
	public AddElementsPage(WebDriver driver) throws Exception
	{
		this.driver=driver;
		loginPage=new LoginPage(driver);
	}
	public void enterDetails() throws Exception
	{
		loginPage.enterDetails();
	}
	public void checkForBag() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Bag']")).click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//div[.='Hey, it feels so light!']")).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='myntra-logo']")).click();
			ProductPage productPage=new ProductPage(driver);
			productPage.addTheProduct();
			
		}
	}
}
