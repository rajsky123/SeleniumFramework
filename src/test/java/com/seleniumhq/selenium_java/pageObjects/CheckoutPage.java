package com.seleniumhq.selenium_java.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumhq.selenium_java.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By waitForCountry=By.cssSelector(".ta-results");
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement typeCountry;
	
	
	@FindBy(xpath="(//button [contains (@class, 'ta-item' )]) [2]")
	WebElement selectSec;
	
	@FindBy(css=".action__submit")
	WebElement confirmation;
	
	public void selectCountry(String country) {
		Actions a = new Actions (driver);
		a.sendKeys(typeCountry, country). build().perform();
		waitForElementToAppear(waitForCountry);
		selectSec.click();
	}
	
	public ConfirmationPage goToConfirmationPage()
	{
		confirmation.click();
		return new ConfirmationPage(driver);
	}
	
	
}
