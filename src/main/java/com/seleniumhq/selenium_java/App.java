package com.seleniumhq.selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println(driver.getTitle());
		driver.findElement(By.id("inputUsername")).sendKeys("rajaji");
		driver.findElement(By.name("inputPassword")).sendKeys("rajajipwd");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.className("forgot-pwd-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rajaji");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("rajaji@jojo.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("88778");
		driver.findElement(By.className("reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();


	}
}
