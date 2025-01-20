package com.api.listener;

import com.api.base.TestBase;
import com.api.extentReportManager.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);
    public void onTestStart(ITestResult result) {
        logger.info("Test Stared!!" + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("PASSED!!" + result.getMethod().getMethodName());
        logger.info("DESCRIPTION!!" + result.getMethod().getDescription());
        extentTest.pass("PASSED!!" + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("FAILED!!" + result.getMethod().getMethodName());
        logger.info("DESCRIPTION!!" + result.getMethod().getDescription());
        extentTest.fail("FAILED!!" + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onStart(ITestContext context) {

        logger.info("Test Suite Started! " + context.getName());
        if(extentReport == null) {
            extentReport = ExtentReportManager.createInstance();
        }
        extentTest = extentReport.createTest(context.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed!");
        extentTest.info(context.getName() + " test finished");
    }
}
