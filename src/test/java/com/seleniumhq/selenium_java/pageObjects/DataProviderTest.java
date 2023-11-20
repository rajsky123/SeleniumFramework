package com.seleniumhq.selenium_java.pageObjects;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumhq.selenium_java.AbstractComponents.Retry;
import com.seleniumhq.selenium_java.Base.BaseTest;

public class DataProviderTest extends BaseTest{
	
	@Test(dataProvider = "getData",retryAnalyzer = Retry.class)
	public void errorValidation(String email,String passwd,String productName) throws IOException {
	
	//String productName="IPHONE 13 PRO";
	ProductCatalogue catalogue = landingPage.loginApplication(email, passwd);
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
	@DataProvider (name = "getData")
    public Object[][] getData(){ 
    return new Object[][] {{"ravikhan@academy.com", "Kingkhan@007" , "IPHONE 13 PRO"}, {"1kingkhan@academy.com", "Kingkhan@123", "IPHONE 13 PRO"}};
    }

	
	
}
