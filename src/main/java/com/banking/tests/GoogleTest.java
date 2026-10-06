package com.banking.tests;

import org.testng.annotations.Test;

import com.banking.base.BaseTest;
import com.banking.utils.LoggerUtils;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {

        LoggerUtils.info("Google test started");

        String title = driver.getTitle();

        LoggerUtils.info("Google page title: " + title);

        System.out.println("Google Title: " + title);

        LoggerUtils.info("Google test completed");
    }
}