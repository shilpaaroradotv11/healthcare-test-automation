package com.healthcare.automation.data;

import org.testng.annotations.DataProvider;

public class SignupDataProvider {

    @DataProvider(name = "signupData")
    public Object[][] signupData() {

        String email = "medicare.test" + System.currentTimeMillis()
                + "@example.com";

        return new Object[][] {
            {
                "Test",
                "User",
                email,
                "9876543210",
                "Test@12345",
                "Test@12345",
                "123 Test Street",
                "Suite 2",
                "Bangalore",
                "560001",
                "Karnataka",
                "India"
            }
        };
    }
    
}
