package com.healthcare.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.healthcare.automation.utilities.AppConfigurations;

import java.io.IOException;

public class DriverFactory {
	 private static final ThreadLocal<WebDriver> localDriver =
             new ThreadLocal<>();

    public static WebDriver createDriver() throws IOException {

        AppConfigurations config = new AppConfigurations();
        String browser = config.getBrowser();

        WebDriver driver;

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        
        localDriver.set(driver);

        return driver;
    }

    public static void quitDriver() {
        if (localDriver.get() != null) {
            localDriver.get().quit();
            localDriver.remove();
        }
    }
}