package com.RahulShetty.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentTest test;

	static {
		 String folderPath = System.getProperty("user.dir") + "/ExtentReports/";
	        String reportPath = folderPath + "ExtentReport.html";

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setReportName("Automation Test Results");
		spark.config().setDocumentTitle("Automation Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
}
