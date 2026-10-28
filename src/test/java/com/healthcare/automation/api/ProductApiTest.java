package com.healthcare.automation.api;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import com.healthcare.automation.utilities.ExtentTestListener;

public class ProductApiTest {

    @Test
    public void verifyGetAllProductsStatusCode() {
    	ExtentTestListener.log("Sending GET request for all products");
    	
        given()
        .when()
            .get("http://localhost:8080/medicare2/show/all/products")
        .then()
            .statusCode(200);
    }

    @Test
    public void verifyCategoryProductAnalgesics() {

    	ExtentTestListener.log("Checking Analgesics category response");
    	
        given()
        .when()
            .get("http://localhost:8080/medicare2/show/category/2/products")
        .then()
            .statusCode(200)
            .body(containsString("Analgesics"));
    }
}
