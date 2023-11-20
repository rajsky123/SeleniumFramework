package com.seleniumhq.selenium_java.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReporterNG()
	{
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extentReports= new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "Rajiv");
		return extentReports;
	}

}
