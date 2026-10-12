# Healthcare Test Automation

A healthcare-domain test automation project built with Selenium WebDriver, TestNG, REST Assured, Maven, and Extent Reports.

## Technology Stack
- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- REST Assured
- Extent Reports

## Project Coverage

### UI Automation
- User signup
- Valid and invalid login
- Adding one product to the cart and validating checkout
- Adding two products to the cart and validating checkout

### API Automation
- Verify the status code for retrieving all products
- Verify the product category response contains "Analgesics"

### Reporting
Extent Reports records test outcomes and logged execution steps in an HTML report.

## Prerequisites
- Java 21
- Maven
- Eclipse or another Java IDE
- The Medicare web application running locally at `http://localhost:8080`

## How to Run

1. Clone this repository.
2. Import the project as an existing Maven project.
3. Confirm the Medicare application is running locally.
4. Run `testng.xml` for the complete sequential test suite.
5. Run `testng-parallel.xml` for the configured parallel UI/API suite.
6. Run `testng-cart.xml` separately for sequential cart tests.

## Test Reports
After execution, open `test-output/ExtentReport.html` to review test results and logged steps.

## Notes
The application must be available locally for the UI and API tests. Jenkins integration is planned as a future enhancement.