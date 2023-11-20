package com.seleniumhq.selenium_java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowActivities2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector("a[class*='nkingT']")).click();
		
		Set<String> winSet = driver.getWindowHandles();
		
		Iterator<String> it = winSet.iterator();
		
		String parentID= it.next();
		String childID= it.next();
		
		
		driver.switchTo().window(childID);
		
		String text = driver.findElement(By.xpath("//div[@class='col-md-8']/p[@class='im-para red']")).getText();
		String[] split = text.split(" ");
		for (String sp : split) {
			if(sp.contains("@"))
			{
				driver.switchTo().window(parentID);
				driver.findElement(By.id("username")).sendKeys(sp);
				break;
			}
		}
		
		
		driver.switchTo().window(childID);
		
		driver.findElement(By.xpath("//ul[@class='footer-nav']/li[1]/following-sibling::li[1]")).click();
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeScript("scrollBy(0,4500)");  
		
		
	}

}
