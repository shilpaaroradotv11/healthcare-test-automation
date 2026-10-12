
package com.healthcare.automation.tests;

import com.healthcare.automation.utils.ExtentTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.automation.base.BaseTest;
import com.healthcare.automation.data.LoginDataProvider;
import com.healthcare.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class)
	public void verifyLoginWithInvalidCredentials(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickLoginLink();
		ExtentTestListener.log("Entering invalid login credentials");

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		ExtentTestListener.log("Verifying invalid login error");

		Assert.assertEquals(loginPage.getInvalidLoginMessage(), "Username and Password is invalid!",
				"Invalid login error message did not match");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
				"Expected to remain on the login page after invalid login");
	}

	@Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
	public void verifyLoginWithValidCredentials(String username, String password, String expectedUsername) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickLoginLink();
		ExtentTestListener.log("Entering valid login credentials");

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.waitForHomePage();
		ExtentTestListener.log("Verifying successful login");

		Assert.assertEquals(driver.getTitle(), "Medicare - Home", "Login did not navigate to the Medicare home page");

		Assert.assertEquals(loginPage.getLoggedInUsername(), expectedUsername, "Logged-in username did not match");
	}
}
