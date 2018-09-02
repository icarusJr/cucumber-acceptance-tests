package com.ctbnb.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

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

	@Given("I am logged reservation api as teacher")
	public void i_am_logged_reservation_api_as_teacher() {
		RestAssured.baseURI = ConfigurationReader.getProperty("qa1_base_url");

		String email = ConfigurationReader.getProperty("qa1_teacher_email");
		String password = ConfigurationReader.getProperty("qa1_teacher_password");
		Response res = RestAssured.given().param("email", email).param("password", password).when()
				.get(RestAssured.baseURI + "/sign");
		res.then().statusCode(200);
		token = res.jsonPath().get("accessToken");
		System.out.println(token);

	}

	@When("I get the user information by id {int} using the student endpoint")
	public void i_get_the_user_information_by_id_using_the_student_endpoint(Integer id) {
		RestAssured.basePath = "api/students/" + id;
		responce = RestAssured.given().header("Authorization", token).and().when().get();
		responce.then().statusCode(200);

	}

	@Then("the correct user information should be returned by the student endpoint")
	public void the_correct_user_information_should_be_returned_by_the_student_endpoint(Map<String, String> user) {
		String expectedFirstName = user.get("firstName");
		String expectedLastName = user.get("lastName");
		String expectedRole = user.get("role");
		String expectedId = user.get("id");

		String actualFistName = responce.jsonPath().get("firstName");
		String actualLastName = responce.jsonPath().get("lastName");
		String actualRole = responce.jsonPath().get("role");
		String actualId = responce.jsonPath().getString("id");

		assertEquals(expectedFirstName, actualFistName);
		assertEquals(expectedLastName, actualLastName);
		assertEquals(expectedId, actualId);
		assertEquals(expectedRole, actualRole);

	}

}
