package com.api.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test Stared!!" + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("PASSED!!" + result.getMethod().getMethodName());
        logger.info("DESCRIPTION!!" + result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("FAILED!!" + result.getMethod().getMethodName());
        logger.info("DESCRIPTION!!" + result.getMethod().getDescription());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started!");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed!");
    }
}
