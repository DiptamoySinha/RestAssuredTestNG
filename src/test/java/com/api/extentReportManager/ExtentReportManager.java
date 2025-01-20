package com.api.extentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    public static ExtentReports extentReport;

    public static ExtentReports createInstance() {
        ExtentReports extentReport = new ExtentReports();

        // Define the report directory and ensure it exists
        String reportDirectory = System.getProperty("user.dir") + File.separator + "reports";
        File reportsDir = new File(reportDirectory);
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        // Define the report file path
        String reportFilePath = reportDirectory + File.separator + "extent.html";

        // Set up ExtentSparkReporter
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFilePath);
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReport;
    }
}
