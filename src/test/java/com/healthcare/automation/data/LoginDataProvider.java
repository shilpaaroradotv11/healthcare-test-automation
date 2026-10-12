package com.healthcare.automation.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    
	@DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
            {
                "invalid.user@example.com",
                "WrongPassword@123"
            }
        };
    }
	
	
	@DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][] {
            {
                "sarora@gmail.com",
                "sukhse",
                "shilpa arora"
            }
        };
    }
	
}
