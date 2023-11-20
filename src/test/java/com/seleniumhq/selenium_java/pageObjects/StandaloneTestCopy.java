package com.seleniumhq.selenium_java.pageObjects;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.seleniumhq.selenium_java.Base.BaseTest;

public class StandaloneTestCopy extends BaseTest{
	
	@Test
	public void submitOrder() throws IOException {
	
	String productName="IPHONE 13 PRO";
	ProductCatalogue catalogue = landingPage.loginApplication("kingkhan@academy.com", "Kingkhan@123");
	catalogue.addProductToCart(productName);
	CartPage cartPage = catalogue.goToCartPage();
	
	
	boolean match = cartPage.getCartProduct(productName);
	AssertJUnit.assertTrue (match);
	
	
	CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
	checkoutPage.selectCountry("india");
	ConfirmationPage goToConfirmationPage = checkoutPage.goToConfirmationPage();
	
	
	String confirmMessage = goToConfirmationPage.confirmationMsg();
	Assert.assertTrue (confirmMessage.equalsIgnoreCase ("THANKYOU FOR THE ORDER.")); 


}
	
}
