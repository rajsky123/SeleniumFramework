package com.seleniumhq.selenium_java.AbstractComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
     int cnt=2;
	@Override
	public boolean retry(ITestResult result) {
		if(cnt-->0)
			return true;
		return false;
	}

}
