package com.seleniumhq.selenium_java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumhq.selenium_java.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productBy=By.className("col-lg-4");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMsg=By.cssSelector("#toast-container");
	
	@FindBy(className="col-lg-4")
	List<WebElement> products;
	
	
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	
	public WebElement getProductByName(String productName) {
		WebElement desProd = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return desProd;
	}
	
	public void addProductToCart(String productName) {
		 getProductByName(productName).findElement(addToCart).click();
		 waitForElementToAppear(toastMsg);
	}
	
	
}
