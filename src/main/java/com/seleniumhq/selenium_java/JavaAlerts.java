package com.seleniumhq.selenium_java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions act=new Actions(driver);

	
		driver.get("https://www.spicejet.com/");
		act.moveToElement(driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']"))).click().sendKeys("ban").build().perform();
		List<WebElement> source=driver.findElements(By.cssSelector("div[data-testid='to-testID-origin'] div[class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3'] div[class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']"));
	
		for (WebElement webElement : source) {
			if(webElement.getText().contains("Bengaluru"))
				{webElement.click();
				
				 break;
				}
					
			
		}
	
		
		driver.findElement(By.cssSelector("div[data-testid='to-testID-destination'] input[class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("che");
		List<WebElement> dest=driver.findElements(By.cssSelector("div[data-testid='to-testID-destination'] div[class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3'] div[class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73']"));
		for (WebElement webElement : dest) {
			if(webElement.getText().contains("Chennai"))
				{webElement.click();
				
				 break;
				}
					
			
		}
		
		List<WebElement> months = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']"));
		
		for (int i=1;i<months.size();i++) {
			if(months.get(i).getText().contains("June"))
			{
				months.get(i).findElement(By.cssSelector("div[data-testid='undefined-calendar-day-10']")).click();
				break;
			}
		}
	
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers']")).click();
		
		for(int i=1;i<=4;i++) {
		driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
		}
		
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		List<WebElement> cur = driver.findElements(By.cssSelector("div[class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-8fdsdq'] div[class='css-76zvg2 r-homxoj r-ubezar']"));
		
		for (WebElement curr : cur) {
			if(curr.getText().contains("CNY"))
					{curr.click();
					 break;
					}
		}
		
		List<WebElement> select = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']"));
		
		for (WebElement selects : select) {
			if(selects.getText().contains("Armed Forces")) {
				selects.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("div[data-testid='home-page-flight-cta']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  implicit wait
		WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(10));   //explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1otgn73']/div[@class='css-1dbjc4n r-zso239']")));
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1otgn73']/div[@class='css-1dbjc4n r-zso239']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		
	}
	
}