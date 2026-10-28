package com.healthcare.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthcare.automation.utilities.WaitUtils;

public class ProductPage {

	private WebDriver driver;
	private WaitUtils waitUtils;

	// Home page Product selection from category Antipyretics
	private By antipyreticsCategory = By.id("a_Antipyretics");
	private By AddToCartButtonAntipyretics = By
			.cssSelector("tbody tr:nth-child(2) td:last-child a[href*='/cart/add/']");

	// View Products link Product selection
	private By viewProductsLink = By.cssSelector("#listProducts a");
	private By addToCartButtonSecondProduct = By
			.cssSelector("#productListTable tbody tr:first-child a[href*='/cart/add/']");

	// Cart table
	private By cartRows = By.cssSelector("#cart tbody tr");

	private By checkoutButton = By.linkText("Checkout");
	private By selectShippingAddressHeading = By.xpath("//h4[contains(text(),'Select Shipping Address')]");
	private By removeButtons = By.cssSelector("a[href*='/remove']");
	private By cartTable = By.cssSelector("table#cart");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);
	}

	public void clickAntipyreticsCategory() {
		waitUtils.clickWhenReady(antipyreticsCategory);
	}

	public void addFirstProductToCart() {
		waitUtils.clickWhenReady(AddToCartButtonAntipyretics);
	}

	public void clickViewProducts() {
		waitUtils.clickWhenReady(viewProductsLink);
	}

	public void addSecondProductToCart() {
		waitUtils.clickWhenReady(addToCartButtonSecondProduct);
	}

	public int getCartItemCount() {
		return driver.findElements(cartRows).size();
	}

	public void clickCheckout() {
		waitUtils.clickWhenReady(checkoutButton);
	}

	public String getCheckoutHeading() {
		return waitUtils.waitForVisibility(selectShippingAddressHeading).getText();
	}

	public boolean waitForCartItemCount(int expectedCount) {
		return waitUtils.waitForCartItemCount(expectedCount);
	}

	public void waitForCartPage() {
		waitUtils.waitForVisibility(cartTable);
	}

	public void removeAllCartItems() {
		while (!driver.findElements(removeButtons).isEmpty()) {
			waitUtils.clickWhenReady(removeButtons);
		}
	}
}
