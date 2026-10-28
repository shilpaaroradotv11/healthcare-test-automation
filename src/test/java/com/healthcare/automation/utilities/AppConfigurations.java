package com.healthcare.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfigurations {

    private Properties properties;

    public AppConfigurations() throws IOException {
        FileInputStream input = new FileInputStream(
                "src/test/resources/AppConfig.properties");

        properties = new Properties();
        properties.load(input);
        input.close();
    }

    public String getAppURL() {
        return properties.getProperty("AppUrl");
    }

    public String getBrowser() {
        return properties.getProperty("Browser");
    }
    
   
}