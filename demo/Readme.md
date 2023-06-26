# API Testing with TestNG - README

This project provides an example of API testing using the RestAssured library and demonstrates how to use Request and Response Spec Builders. It includes a test class named `Devops1APITest` that validates the response from an API endpoint. Assertions are used to validate the response data and ensure the API behavior.

## Prerequisites
- Java Development Kit (JDK) 8 or higher installed on your machine
- Apache Maven installed on your machine (optional, for managing dependencies and building the project)

## Setup
1. Clone the repository or download the source code.
2. Open a terminal or command prompt and navigate to the project directory.
3. (Optional) If you have Maven installed, you can build the project using the following command:
   ```
   mvn clean install
   ```
   This will download the required dependencies and compile the source code.

## Running the Test

### Command Line
1. Clone the repository or download the project files.
2. Navigate to the project directory in the command line.
3. Run the tests using Maven command:
   ```
   mvn clean test
   ```
   The test results will be displayed in the console.

### IDE (Eclipse, IntelliJ IDEA, etc.)
1. Import the project into your IDE.
2. Build the project to ensure that the dependencies are resolved.
3. Run the test class `Devops1APITest` as a TestNG test.
4. The test results will be displayed in the IDE's test runner.

## Test Description
The `Devops1APITest` class includes a main method that performs the following steps:
1. Sets up the request specification using the `RequestSpecBuilder`, including the base URI and query parameters.
2. Sends a GET request to the API endpoint using RestAssured, with the specified request specification.
3. Sets up the response specification using the `ResponseSpecBuilder`, expecting a status code of 200.
4. Extracts the response body and maps it to the `GetUsers` class using the `extract().as()` method.

The `Devops1APITest` class contains two test methods:
1. `validateUsers()` - This test validates that the 'first_name' array in the response from page 2 does not contain the value "Jack". It retrieves the response data, extracts the 'first_name' values, and asserts that "Jack" is not present.
2. `emptyDataArray()` - This test validates that the 'data' array in the response from page 3 is empty. It retrieves the response data and asserts that the 'data' array is empty.

## Test Results
The test results will indicate whether the API tests pass or fail. Assertion failures will be reported if the expected conditions are not met.
It is important to ensure that the API server is up and running and the endpoint URLs are valid to obtain accurate test results.
Feel free to modify the test methods or add new test methods as per your requirements.
For any issues or inquiries, please reach out to raziv.parazuli@gmail.com.

## Customization
You can customize the test by modifying the following aspects:
- API endpoint: You can change the base URI and query parameters in the request specification setup.
- Validation: If you have additional requirements or validations, you can modify the assertions in the test methods.

## Troubleshooting
If you encounter any issues while running the tests, consider the following troubleshooting steps:
- Verify the API endpoint: Check if the API endpoint or base URI has changed. Update the code accordingly if necessary.
- Network Connectivity: Ensure that you have a stable internet connection to access the API endpoint.
- Dependencies: Double-check that the required dependencies (RestAssured, TestNG,

 etc.) are correctly configured in your project's build file (pom.xml) or build.gradle file.
- TestNG Plugin: If you are running the tests from an IDE, ensure that the TestNG plugin is properly installed and configured.
- Debugging: If you need to debug the code, set breakpoints in the test code and use the debugging features provided by your IDE.
- Logging: Add log statements in your test code to track the execution flow and debug any issues.

## References
- [RestAssured Documentation](https://rest-assured.io/)
- [TestNG Documentation](https://testng.org/doc/)

For additional information, please refer to the official documentation of RestAssured and TestNG. If you encounter any specific issues with this project, feel free to raise an issue in the project repository on GitHub.