package com.api.extentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extentReport;

    public static ExtentReports createInstance() {
        extentReport = new ExtentReports();
        String reportFilePath = System.getProperty("user.dir") + "\\reports\\" + "extent.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFilePath);
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("OS", System.getProperty("java.version"));
        return extentReport;
    }
}
