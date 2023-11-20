package com.seleniumhq.selenium_java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassw;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email,String password) {
		
		userEmail.sendKeys(email);
		userPassw.sendKeys(password);
		submit.click();
		ProductCatalogue catalogue = new ProductCatalogue(driver);
		return catalogue;
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
}
