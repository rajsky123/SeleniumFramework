package com.seleniumhq.selenium_java.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumhq.selenium_java.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
	
	public boolean getCartProduct(String productName) {
		return cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	}
	
	public CheckoutPage goToCheckoutPage() {
		checkout.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	
}
