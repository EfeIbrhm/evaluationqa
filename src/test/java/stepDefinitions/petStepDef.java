package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class petStepDef {

    Response response;
    String pet_POST="https://petstore.swagger.io/v2/pet";


        @When("user naviagte to the {string} api end point")
        public void userNaviagteToTheApiEndPoint(String endPoint) {
            response=given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(endPoint);
    }
    @Then("user verifies header in response body")
    public void userVerifiesHeaderInResponseBody() {
        System.out.println("Headers :  = " + response.getHeaders());
    }
    @When("user verifies status code is {int}")
    public void user_verifies_stattus_code_is(Integer statusCode) {

        Assert.assertTrue(statusCode.equals(200));

    }
    @Then("user verifies contet type is  {string}")
    public void userVerifiesContetTypeIs(String contentType) {
        Assert.assertEquals(response.contentType(),contentType);
    }

    //***********************POST REQUEST ********************
    @When("user naviagte to the {string} api end point.")
    public void user_naviagte_to_the_api_end_point(String endPost) {
        Map data= new HashMap();
        data.put("id","9");
        data.put("name","pamuk");

        response=given()
                .contentType(ContentType.JSON)
                .body(data) //Request Body or Payload
                .when()
                .post(endPost);
        response.prettyPrint();

        System.out.println("StatusCode  = " + response.getStatusCode());

       Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getContentType(),"application/json");
    }
    @When("user sets the request body")
    public void user_sets_the_request_body() {


    }
    @And("user verifies name is created in response body")
    public void userVerifiesNameIsCreatedInResponsBody() {
       String name = "pamuk";
        Assert.assertEquals(response.jsonPath().get("name"),name);
    }

    //***********************  DELETE REQUEST ********************
    @When("user naviagte to the delete {string} api end point..")
    public void user_naviagte_to_the_delete_api_end_point(String string) {
                response=given()
                .contentType(ContentType.JSON)
                .when()
                .delete(string);

       Assert.assertEquals(response.getStatusCode(),200);
       Assert.assertEquals(response.getContentType(),"application/json");

    }
    @When("user verifies response message")
    public void user_verifies_response_message() {
            Object message = response.jsonPath().get("message");
            Assert.assertEquals(response.jsonPath().get("message"),message);

    }

}
