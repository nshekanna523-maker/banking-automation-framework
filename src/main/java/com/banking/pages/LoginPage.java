package com.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.banking.utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // Locator
    private By searchBox = By.name("q");

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Enter text into search box
    public void enterSearchText(String text) {

        waitUtils.enterText(searchBox, text);
    }

    // Click/Search
    public void search() {

        waitUtils.click(searchBox);
    }
}