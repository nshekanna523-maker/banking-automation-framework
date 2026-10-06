package com.banking.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Banking Automation");
            extent.setSystemInfo("Tester", "Sridhar");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}