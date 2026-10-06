package com.banking.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.banking.drivers.DriverFactory;
import com.banking.drivers.DriverManager;
import com.banking.utils.ConfigReader;
import com.banking.utils.LoggerUtils;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        LoggerUtils.info("Test setup started");

        ConfigReader.loadProperties();

        LoggerUtils.info("Configuration loaded");

//        WebDriver webDriver = DriverFactory.createDriver();

        WebDriver webDriver = DriverFactory.createDriver(browser);
        
        LoggerUtils.info("Browser launched successfully: " + browser);

        DriverManager.setDriver(webDriver);

        driver = DriverManager.getDriver();

        driver.get(ConfigReader.getProperty("url"));

        LoggerUtils.info(
                "Application opened: "
                + ConfigReader.getProperty("url")
        );
    }

    @AfterMethod
    public void tearDown() {

        LoggerUtils.info("Test cleanup started");

        if (DriverManager.getDriver() != null) {

            DriverManager.getDriver().quit();

            LoggerUtils.info("Browser closed");

            DriverManager.unloadDriver();

            LoggerUtils.info("Driver removed");
        }
    }
}