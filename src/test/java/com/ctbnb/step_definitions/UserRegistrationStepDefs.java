package com.ctbnb.step_definitions;

import static org.junit.Assert.assertEquals;

import com.prestashop.utilities.RestUtils;
import com.prestashop.utilities.RestUtils.UserType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserRegistrationStepDefs {

	private String token;
	private Response responce;

	@Given("I am logged reservation api as team lead")
	public void i_am_logged_reservation_api_as_team_lead() {
		token = RestUtils.accessToken(UserType.LEADER);

	}

	@When("I try to register a new user")
	public void i_try_to_register_a_new_user() {
		responce = RestAssured.given().header("Authorization", RestUtils.token)
				// .param("first-name", "Johnny")
				.param("last-name", "Cage").param("email", "johnnycage@gmail.com")
				.param("password", "subzerobest")
				.param("role", "student-team-member")
				.param("batch-number", "8")
				.param("team-name", "CodeHunters")
				.param("campus-location", "VA")
				.when().post(RestAssured.baseURI + "/api/students/student");
	}

	@Then("system should return only teacher can register message")
	public void system_should_return_only_teacher_can_register_message() {
		responce.then().statusCode(403);
		assertEquals("only teacher allowed to modify database.", responce.body().asString());
	}

	@Given("I am logged reservation api as team member")
	public void i_am_logged_reservation_api_as_team_member() {
		token = RestUtils.accessToken(UserType.MEMBER);
	}

	@Then("the teacher should be authorised to add users")
	public void the_teacher_should_be_authorised_to_add_users() {
		responce.then().statusCode(422);
		assertEquals("pay attentisdfsdon to how you specifying first-name in the query.", responce.body().asString());

	}

}
