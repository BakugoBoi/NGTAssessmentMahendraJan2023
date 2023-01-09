package com.app.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {

	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void addTheProduct() throws InterruptedException
	{
		 driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Kansas 57 Cabin Trolley");
		 driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
		 driver.findElement(By.xpath("//img[@title='AMERICAN TOURISTER Blue & Black Kansas Spinnerinner 57 Cabin Trolley Suitcase']")).click();
		 String currentHandle = driver.getWindowHandle();
	        Set<String> handles = driver.getWindowHandles();
	        for(String actual: handles) {
	            if(!actual.equalsIgnoreCase(currentHandle)) {
	                driver.switchTo().window(actual);
	            }
	        }
	    
	    driver.findElement(By.xpath("//div[normalize-space()='ADD TO BAG']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='Bag']")).click();
	    Thread.sleep(3000);
		System.out.println("Passed");
	}
}
