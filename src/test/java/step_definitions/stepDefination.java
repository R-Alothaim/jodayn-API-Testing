package step_definitions;

import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import TestDataBuilder.APIResources;
import TestDataBuilder.TestData;
import TestDataBuilder.utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
@RunWith(Cucumber.class)
public class stepDefination extends utils {
  RequestSpecification res;
  ResponseSpecification resspec;
  Response response;
  TestData data = new TestData();
  static String place_id;
  @Given("Add place {string} {string} {string}")
public void add_place(String string, String string2, String string3) throws IOException {
   
  resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(io.restassured.http.ContentType.JSON).build();
  res = given().spec(requestspec()).body(data.addplace(string, string2, string3));
}
  @When("user calls {string} with {string} http request")
  public void httprequest(String string, String string2) {
    APIResources resourceAPI = APIResources.valueOf(string);
    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(io.restassured.http.ContentType.JSON).build();
    if(string2.equalsIgnoreCase("POST")){
    response = res.when().post(resourceAPI.getResource()).then().spec(resspec).extract().response();
    }
    else if(string2.equalsIgnoreCase("GET")){
      response = res.when().get(resourceAPI.getResource()).then().spec(resspec).extract().response();
    }else if(string2.equalsIgnoreCase("DELETE")){
      response = res.when().delete(resourceAPI.getResource()).then().spec(resspec).extract().response();
    }
  }
  @Then("{string} in response body is {string}")
public void in_response_body_is(String string, String string2) {
    assertEquals(getJsonPath(response, string), string2);
}
  @And("verify place_id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using_get_place_api(String string, String string2) throws IOException {
 place_id = getJsonPath(response, "place_id");
    res = given().spec(requestspec()).queryParam("place_id", place_id);
     httprequest(string2, "GET");
     String name = getJsonPath(response, "name");
      assertEquals(name, string);
}
@Given("Delete place payload")
public void delete_place_payload() throws IOException {
res = given().spec(requestspec()).body(data.deleteplace(place_id));
}
}

