package com.healthcare.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.automation.base.BaseTest;
import com.healthcare.automation.data.SignupDataProvider;
import com.healthcare.automation.pages.SignupPage;
import com.healthcare.automation.utilities.ExtentTestListener;

public class SignupTest extends BaseTest {

	@Test(dataProvider = "signupData", dataProviderClass = SignupDataProvider.class)
	public void verifyUserSignup(String firstName, String lastName, String email, String contactNumber, String password,
			String confirmPassword, String addressLineOne, String addressLineTwo, String city, String postalCode,
			String state, String country) {

		SignupPage signupPage = new SignupPage(driver);

		signupPage.clickSignUp();
		
		ExtentTestListener.log("Starting user signup");

		signupPage.enterFirstName(firstName);
		signupPage.enterLastName(lastName);
		signupPage.enterEmail(email);
		signupPage.enterContactNumber(contactNumber);
		signupPage.enterPassword(password);
		signupPage.enterConfirmPassword(confirmPassword);

		signupPage.selectUserRole();
		signupPage.clickNextBilling();

		signupPage.enterAddressLineOne(addressLineOne);
		signupPage.enterAddressLineTwo(addressLineTwo);
		signupPage.enterCity(city);
		signupPage.enterPostalCode(postalCode);
		signupPage.enterState(state);
		signupPage.enterCountry(country);

		signupPage.clickNextConfirm();
		signupPage.clickConfirm();
		
		ExtentTestListener.log("Verifying successful registration");


		Assert.assertEquals(signupPage.getWelcomeMessage(), "Welcome!", "Signup success message did not match");
	}
}
