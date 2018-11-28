package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.*;
import io.restassured.specification.*;
import io.restassured.response.Response;

public class Steps {

	private int id;
	private String name;
	private String duration;
	private String endPointUrl;

	private int statusCode;
	private Response response;

	@Given("the id is {string}")
	public void the_id_is(String strId) {
		id = Integer.parseInt(strId);	
	}

	@Given("the name of the training is {string}")
	public void the_name_of_the_training_is(String name) {
		this.name = name;	
	}

	@Given("the duration of the training is {string}")
	public void the_duration_of_the_training_is(String duration) {
		this.duration = duration;
	}

	@When("I invoke the POST endpoint {string}")
	public void i_invoke_the_endpoint(String url) {
		endPointUrl = url;	
	
		RestAssured.baseURI = "http://localhost:8080/tektutor-restful-ws-1.0.0/rest/trainings";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put ("id", id );
		requestParams.put ("name", name );
		requestParams.put ("duration", duration ); 	

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		response = request.post("");

		statusCode = response.getStatusCode();
	}

	@Then("I expect the training object to get added to database.")
	public void i_expect_the_training_object_to_get_added_to_database() {
		assertEquals(statusCode,200);
		String successCode = response.jsonPath().get("SuccessCode");
		//assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

	@Then("I expect the training object updated in the database.")
	public void i_expect_the_training_object_updated_in_the_database() {
		assertEquals(statusCode, 200);
		String successCode = response.jsonPath().get("SuccessCode");
		//assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

	@When("I invoke the PUT endpoint {string}")
	public void i_invoke_the_PUT_endpoint(String url) {
		endPointUrl = url;	
	
		RestAssured.baseURI = "http://localhost:8080/tektutor-restful-ws-1.0.0/rest/trainings";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put ("id", id );
		requestParams.put ("name", name );
		requestParams.put ("duration", duration ); 	

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		response = request.put("");

		statusCode = response.getStatusCode();
	}

	@Given("the record exits")
	public void the_record_exits() {
		
	}

	@When("I invoke the GET endpoint {string}")
	public void i_invoke_the_GET_endpoint(String endpointUrl) {
		this.endPointUrl = endpointUrl;

		RestAssured.baseURI = this.endPointUrl; 
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.get("");
		statusCode = response.getStatusCode();
	}

	@Then("I expect the training record that matches the id should be retrieved")
	public void i_expect_the_training_record_that_matches_the_id_should_be_retrieved() {
		assertEquals(statusCode, 200);
	}

}
