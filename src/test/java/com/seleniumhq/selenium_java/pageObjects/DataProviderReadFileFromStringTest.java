package com.seleniumhq.selenium_java.pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumhq.selenium_java.AbstractComponents.DataReader;
import com.seleniumhq.selenium_java.AbstractComponents.Retry;
import com.seleniumhq.selenium_java.Base.BaseTest;

public class DataProviderReadFileFromStringTest extends BaseTest{
	
	@Test(dataProvider = "getData",retryAnalyzer = Retry.class)
	public void dataReadFromJson(Map<String, String> map) throws IOException {
	
	//String productName="IPHONE 13 PRO";
	ProductCatalogue catalogue = landingPage.loginApplication(map.get("email"), map.get("password"));
	catalogue.addProductToCart(map.get("productName"));
	CartPage cartPage = catalogue.goToCartPage();
	
	
	boolean match = cartPage.getCartProduct(map.get("productName"));
	AssertJUnit.assertTrue (match);
	
	
	CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
	checkoutPage.selectCountry("india");
	ConfirmationPage goToConfirmationPage = checkoutPage.goToConfirmationPage();
	
	
	String confirmMessage = goToConfirmationPage.confirmationMsg();
	Assert.assertTrue (confirmMessage.equalsIgnoreCase ("THANKYOU FOR THE ORDER.")); 


}
	@DataProvider (name = "getData")
    public Object[][] getData(){ 
	List<HashMap<String, String>> jsonToMap=null;
	Object ob[][]=null;
	try {
		jsonToMap = DataReader.getJsonToMap();
		ob=new Object[jsonToMap.size()][1];
		for(int i=0;i<ob.length;i++)
		 ob[i][0]=jsonToMap.get(i);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return ob;
    }
	
	
	
}
