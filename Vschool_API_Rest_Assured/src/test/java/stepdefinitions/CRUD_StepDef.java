package stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CRUD_StepDef {
	Response res;
	public static String dynamicId; // Store ID created during POST for reuse in PUT/DELETE

	@Given("I have a base URI of {string}")
	public void i_have_a_base_uri_of(String URL) {
		baseURI = URL;
	}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to(String endPoint) {
		res = given().log().all().when().get(endPoint);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer stsCode) {
		res.then().log().all().statusCode(stsCode);
	}

	@When("I send a POST request to {string} with body as {string}")
	public void i_send_a_post_request_to_with_body_as(String endPoint, String reqBody) {
		res = given().log().all().header("Content-Type", "application/json").body(reqBody).when().post(endPoint);

		dynamicId = res.jsonPath().getString("_id");
		System.out.println("Created ID: " + dynamicId);
	}

	@Then("the response time less than {long}")
	public void the_response_time_less_than(Long millSec) {
		res.then().time(lessThan(millSec));
	}

	@When("I send a PUT request to {string} with body as {string}")
	public void i_send_a_put_request_to_with_body_as(String endPoint, String updateBody) {
		String finalEndPoint = endPoint.contains("<Id>") ? endPoint.replace("<Id>", dynamicId) : endPoint;

		res = given().log().all().header("Content-Type", "application/json").body(updateBody).when().put(finalEndPoint);
	}

	@Then("the response body should contain {string}")
	public void the_response_body_should_contain(String expectedValue) {
		res.then().log().all().body("title", containsString(expectedValue));
	}

	@When("I send a DELETE request to {string}")
	public void i_send_a_delete_request_to(String endPoint) {
		String finalEndPoint = endPoint.contains("<Id>") ? endPoint.replace("<Id>", dynamicId) : endPoint;

		res = given().log().all().when().delete(finalEndPoint);
	}

	@Then("the response header {string} should be {string}")
	public void the_response_header_should_be(String headerName, String expectedValue) {
		res.then().log().all().header(headerName, equalTo(expectedValue));
	}
}
