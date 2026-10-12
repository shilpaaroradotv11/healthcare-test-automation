
package com.healthcare.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriverWait wait;
	
	// Loading overlay used by the Medicare application
    private By loadingOverlay = By.cssSelector(".se-pre-con");

	public WaitUtils(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void waitForTitle(String title) {
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public boolean waitForCartItemCount(int expectedCount) {
	    return wait.until(driver ->
	        driver.findElements(By.cssSelector("#cart tbody tr")).size()
	            == expectedCount
	    );
	}
	
	public void waitForInvisibility(By locator) {
        wait.until(
            ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    // Reusable click with synchronization
    public void clickWhenReady(By locator) {
        waitForInvisibility(loadingOverlay);
        waitForClickable(locator).click();
    }
}