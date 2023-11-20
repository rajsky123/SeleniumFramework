package com.seleniumhq.selenium_java.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.seleniumhq.selenium_java.pageObjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;

	
	public WebDriver initDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src/test//java/com//seleniumhq//selenium_java//resources//GlobalConfig.properties");
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, target);
		return System.getProperty("user.dir")+"//Reports//"+testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApp() throws IOException {
		driver=initDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver. close();
	}
	
}
