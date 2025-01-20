package com.api.base;

import com.api.extentReportManager.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ExtentReports extentReport;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void setup() {
        System.out.println("before suite called!!");
        extentReport = ExtentReportManager.createInstance();
    }

    @AfterSuite
    public void tearDown()
    {
        extentReport.flush();
    }
}
