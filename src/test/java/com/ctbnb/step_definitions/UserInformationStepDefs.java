package com.ctbnb.step_definitions;

import static org.junit.Assert.assertTrue;

import com.prestashop.utilities.ConfigurationReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserInformationStepDefs {

	String token;
	Response responce;
	String user;

	@Given("I am logged reservation api using {string} and {string}")
	public void i_am_logged_reservation_api_using_and(String username, String password) {
		user = username;
		RestAssured.baseURI = ConfigurationReader.getProperty("qa1_base_url");

		Response res = RestAssured.given().param("email", username).param("password", password).when()
				.get(RestAssured.baseURI + "/sign");
		token = res.jsonPath().get("accessToken");
		System.out.println(token);

	}

	@When("I get the current user information using the me endpoint")
	public void i_get_the_current_user_information_using_the_me_endpoint() {
		RestAssured.basePath = "api/students/me";

		responce = RestAssured.given().header("Authorization", token).and().when().get();
		responce.then().statusCode(200);

	}

	@Then("the information about current user should be returned")
	public void the_information_about_current_user_should_be_returned() {
		String firstname = responce.jsonPath().get("firstName");
		String lastname = responce.jsonPath().get("lastName");
		assertTrue(user.contains(firstname.toLowerCase()));
		assertTrue(user.contains(lastname.toLowerCase()));
	}
}
