package com.healthcare.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.healthcare.automation.utilities.AppConfigurations;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        AppConfigurations config = new AppConfigurations();

        driver = DriverFactory.createDriver();
        driver.get(config.getAppURL());
       
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        driver = null;
    }
}