package com.banking.tests;
import com.banking.utils.RetryAnalyzer;
import java.util.Map;

import org.testng.annotations.Test;

import com.banking.base.BaseTest;
import com.banking.pages.LoginPage;
import com.banking.utils.LoggerUtils;
import com.banking.utils.TestDataReader;

public class LoginTest extends BaseTest {

	  @Test(retryAnalyzer = RetryAnalyzer.class)
	    public void verifySearch() {

        LoggerUtils.info("Login test started");

        Map<String, String> testData =
                TestDataReader.readTestData(
                        "src/test/resources/testdata/loginData.json"
                );

        LoggerUtils.info("Test data loaded");

        LoginPage loginPage = new LoginPage(driver);

        LoggerUtils.info("Login page object created");

        loginPage.enterSearchText(
                testData.get("searchText")
        );

        LoggerUtils.info("Search text entered");

        loginPage.search();

        LoggerUtils.info("Search action completed");

        LoggerUtils.info("Login test completed successfully");
    }
}	