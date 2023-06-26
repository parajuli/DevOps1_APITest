package demo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Data;
import pojo.GetUsers;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Devops1APITest {

	@Test(priority=1)
	public void validateUsers() {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in").addQueryParam("page", 2)
				.build();

		// First call to request
		Response resp = RestAssured.given().spec(req).when().get("/api/users");
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();

		// Extract response body and map it to GetUsers class
		GetUsers usersList = resp.then().spec(responseSpec).extract().as(GetUsers.class);
		System.out.println("List of Users: ");
		// Retrieve first_name values from Data objects in the response
		List<String> firstNames = new ArrayList<>();
		for (int i = 0; i < usersList.getData().size(); i++) {
			Data data = usersList.getData().get(i);
			firstNames.add(data.getFirst_name());
			System.out.println(data.getFirst_name());
		}

		// Validate if 'first_name' array contains Jack
		Assert.assertFalse(firstNames.contains("Jack"), "Validation failed: 'first_name' array contains Jack.");
	}
		
		@Test(priority=2)
		public void emptyDataArray() {
		RequestSpecification req2 = new RequestSpecBuilder().setBaseUri("https://reqres.in").addQueryParam("page", 3)
				.build();
		// Second call to request 2
		Response resp2 = RestAssured.given().spec(req2).when().get("/api/users");
		ResponseSpecification responseSpec2 = new ResponseSpecBuilder().expectStatusCode(200).build();

		// Extract response body and map it to GetUsers class
		GetUsers usersList2 = resp2.then().spec(responseSpec2).extract().as(GetUsers.class);

		// Validate if 'data' array is empty in the response from page 3
		Assert.assertTrue(usersList2.getData().isEmpty(),
				"Validation failed: 'data' array is not empty in the response from page 3.");
		System.out.println("The data array in the response from page 3 is " +usersList2.getData());
	}
}
