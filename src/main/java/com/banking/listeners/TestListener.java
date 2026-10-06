package com.banking.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.banking.drivers.DriverManager;
import com.banking.utils.ExtentReportManager;
import com.banking.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        String testName =
                result.getMethod().getMethodName();

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverManager.getDriver(),
                        testName
                );

        test.get().addScreenCaptureFromPath(
                screenshotPath
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();
    }
}