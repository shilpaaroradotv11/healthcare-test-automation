
package com.healthcare.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthcare.automation.utilities.WaitUtils;

public class SignupPage {

	private WaitUtils waitUtils;

	// Locators
	private By signUpLink = By.cssSelector("#signup a");
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By email = By.id("email");
	private By contactNumber = By.id("contactNumber");
	private By password = By.id("password");
	private By confirmPassword = By.id("confirmPassword");
	private By userRole = By.id("role1");
	private By nextBillingButton = By.name("_eventId_billing");

	private By addressLineOne = By.id("addressLineOne");
	private By addressLineTwo = By.id("addressLineTwo");
	private By city = By.id("city");
	private By postalCode = By.id("postalCode");
	private By state = By.id("state");
	private By country = By.id("country");
	private By nextConfirmButton = By.name("_eventId_confirm");
	private By editPersonalButton = By.cssSelector("a[href*='_eventId_personal']");
	private By editBillingButton = By.cssSelector("a[href*='_eventId_billing']");
	private By confirmButton = By.cssSelector("a[href*='_eventId_submit']");
	private By welcomeMessage = By.cssSelector("h1");

	public SignupPage(WebDriver driver) {
		this.waitUtils = new WaitUtils(driver);
	}

	public void clickSignUp() {
		waitUtils.clickWhenReady(signUpLink);
	}

	public void enterFirstName(String value) {
		waitUtils.waitForVisibility(firstName).sendKeys(value);
	}

	public void enterLastName(String value) {
		waitUtils.waitForVisibility(lastName).sendKeys(value);
	}

	public void enterEmail(String value) {
		waitUtils.waitForVisibility(email).sendKeys(value);
	}

	public void enterContactNumber(String value) {
		waitUtils.waitForVisibility(contactNumber).sendKeys(value);
	}

	public void enterPassword(String value) {
		waitUtils.waitForVisibility(password).sendKeys(value);
	}

	public void enterConfirmPassword(String value) {
		waitUtils.waitForVisibility(confirmPassword).sendKeys(value);
	}

	public void selectUserRole() {
		waitUtils.waitForClickable(userRole).click();
	}

	public void clickNextBilling() {
		waitUtils.clickWhenReady(nextBillingButton);
	}

	public void enterAddressLineOne(String value) {
		waitUtils.waitForVisibility(addressLineOne).sendKeys(value);
	}

	public void enterAddressLineTwo(String value) {
		waitUtils.waitForVisibility(addressLineTwo).sendKeys(value);
	}

	public void enterCity(String value) {
		waitUtils.waitForVisibility(city).sendKeys(value);
	}

	public void enterPostalCode(String value) {
		waitUtils.waitForVisibility(postalCode).sendKeys(value);
	}

	public void enterState(String value) {
		waitUtils.waitForVisibility(state).sendKeys(value);
	}

	public void enterCountry(String value) {
		waitUtils.waitForVisibility(country).sendKeys(value);
	}

	public void clickNextConfirm() {
		waitUtils.clickWhenReady(nextConfirmButton);
	}

	public void clickEditPersonal() {
		waitUtils.waitForClickable(editPersonalButton).click();
	}

	public void clickEditBilling() {
		waitUtils.waitForClickable(editBillingButton).click();
	}

	public void clickConfirm() {
	    waitUtils.clickWhenReady(confirmButton);
	}

	public String getWelcomeMessage() {
		return waitUtils.waitForVisibility(welcomeMessage).getText();
	}
}
