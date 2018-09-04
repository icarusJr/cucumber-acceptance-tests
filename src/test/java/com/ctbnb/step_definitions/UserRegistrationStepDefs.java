package com.ctbnb.step_definitions;

import com.prestashop.utilities.RestUtils;
import com.prestashop.utilities.RestUtils.UserType;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistrationStepDefs {

	private String token;

	@Given("I am logged reservation api as team lead")
	public void i_am_logged_reservation_api_as_team_lead() {

		token = RestUtils.accessToken(UserType.LEADER);

	}

	@When("I try to register a new user")
	public void i_try_to_register_a_new_user() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("system should return only teacher can register message")
	public void system_should_return_only_teacher_can_register_message() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
