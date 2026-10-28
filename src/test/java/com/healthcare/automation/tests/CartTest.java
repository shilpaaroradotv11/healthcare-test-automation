
package com.healthcare.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.automation.base.BaseTest;
import com.healthcare.automation.data.LoginDataProvider;
import com.healthcare.automation.pages.LoginPage;
import com.healthcare.automation.pages.ProductPage;
import com.healthcare.automation.utilities.ExtentTestListener;

public class CartTest extends BaseTest {

	@Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
	public void verifyOneItemInCart(String username, String password, String expectedUsername) {

		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);

		// Login
		loginPage.clickLoginLink();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.waitForHomePage();
		ExtentTestListener.log("Adding product to cart");
		// Add first product from category Antipyretics
		productPage.clickAntipyreticsCategory();
		productPage.addFirstProductToCart();
		ExtentTestListener.log("Verifying cart and checkout");

		// Verify one item in cart
		Assert.assertTrue(
				productPage.waitForCartItemCount(1),
				"Cart should contain exactly one product"
				);

		productPage.clickCheckout();

		// Verify page title
		Assert.assertEquals(driver.getTitle(), "Medicare - Membership", "Checkout page title did not match");

		Assert.assertEquals(productPage.getCheckoutHeading(), "Select Shipping Address",
				"Shipping address heading did not match");
		
		// Return to the cart and clean up
		driver.navigate().back();
		productPage.waitForCartPage();
		productPage.removeAllCartItems();
		
	}

	@Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
	public void verifyTwoItemsInCartAndCheckout(String username, String password, String expectedUsername) {

		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);

		// Login
		loginPage.clickLoginLink();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.waitForHomePage();
		ExtentTestListener.log("Adding two products to cart");

		// Add first product from category Antipyretics
		productPage.clickAntipyreticsCategory();
		productPage.addFirstProductToCart();
		
		// Verify first product is in the cart
		Assert.assertTrue(
				productPage.waitForCartItemCount(1),
				"Cart should contain exactly one product after adding the first item"
				);


		// Navigate to View Products page and add second product to cart
		productPage.clickViewProducts();
		productPage.addSecondProductToCart();
		
		ExtentTestListener.log("Verifying two items in cart");
		// Verify two items in cart
		Assert.assertTrue(
				productPage.waitForCartItemCount(2),
				"Cart should contain exactly two products");

		productPage.clickCheckout();

		// Verify page title
		Assert.assertEquals(driver.getTitle(), "Medicare - Membership", "Checkout page title did not match");

		Assert.assertEquals(productPage.getCheckoutHeading(), "Select Shipping Address",
				"Shipping address heading did not match");
		
		
		// Return to the cart and clean up
		driver.navigate().back();
		productPage.waitForCartPage();
		productPage.removeAllCartItems();

	}
}
