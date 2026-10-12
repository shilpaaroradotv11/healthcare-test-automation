
package com.healthcare.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthcare.automation.utils.WaitUtils;

public class LoginPage {

	private WaitUtils waitUtils;

	// Locators
	private By loginLink = By.cssSelector("#login a");
	private By usernamefield = By.id("username");
	private By passwordfield = By.id("password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By loggedInUser = By.cssSelector("#userModel #dropdownMenu1");
	private By invalidLoginMessage = By.cssSelector(".alert-danger");

	public LoginPage(WebDriver driver) {
		this.waitUtils = new WaitUtils(driver);
	}

	public void clickLoginLink() {
	    waitUtils.waitForClickable(loginLink).click();
	}
	
	public void enterUsername(String username) {
		waitUtils.waitForVisibility(usernamefield).sendKeys(username);
	}

	public void enterPassword(String password) {
		waitUtils.waitForVisibility(passwordfield).sendKeys(password);
	}

	public void clickLogin() {
	    waitUtils.waitForClickable(loginButton).click();
	}

	public String getInvalidLoginMessage() {
		return waitUtils.waitForVisibility(invalidLoginMessage).getText().trim();
	}

	public String getLoggedInUsername() {
		return waitUtils.waitForVisibility(loggedInUser).getText().trim();
	}

	public void waitForHomePage() {
		waitUtils.waitForTitle("Medicare - Home");
	}

}
