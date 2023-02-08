package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class storeStepDef {
    Response response;
    String storeIDGet="https://petstore.swagger.io/v2/store/order/6";
    String store_delete="https://petstore.swagger.io/v2/store/order/6";
    String storePost="https://petstore.swagger.io/v2/store/order";

    @Given("user send the request body  {string}  end point")
    public void userSendTheRequestBodyEndPoint(String storePost) {
        Map data= new HashMap();

        data.put("id",6);
        data.put("petId",10);
        data.put("status","placed");
        data.put("complete",true);
        response=given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(storePost);

        response.prettyPrint();


    }
    @When("user sends pet ID  in string format to request body")
    public void userSendsPetIDInStringFormatToRequestBody() {
        Map data= new HashMap();

        data.put("id","6");
        data.put("petId","10");
        data.put("status","placed");
        data.put("complete",true);
        response=given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(storePost);

        response.prettyPrint();

    }
    @Then("user validates response code is {int}")
    public void user_validates_response_code_is(Integer StatusCode) {
        Assert.assertTrue(StatusCode.equals(200));

    }
    @Then("user verifies with order ID created stock is available")
    public void user_verifies_with_order_id_created_stock_is_available() {

        response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(storeIDGet);

        response.prettyPrint();
        Assert.assertTrue(response.jsonPath().get("id").equals(6));


    }


    @Then("user verifies that response contains pet ID and Status")
    public void userVerifiesThatResponseContainsPetIDAndStatus() {

        int id= response.jsonPath().get("id");
        boolean status= response.jsonPath().get("complete");
        Assert.assertEquals(id,6);
        Assert.assertEquals(status,true);


    }


    @Then("user delete created petStore")
    public void userDeleteCreatedPetStore() {
        response=given()
                .contentType(ContentType.JSON)
                .when()
                .delete(store_delete);
    }

    @And("user verifies status code of deleted petStore")
    public void userVerifiesStatusCodeOfDeletedPetStore() {
       int actualStatusCode= response.getStatusCode();
       Assert.assertEquals(actualStatusCode,200);


    }

    @Then("user verifies with GET request if petStore is deleted")
    public void userVerifiesWithGETRequestIfPetStoreIsDeleted() {
        response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(storeIDGet);
        response.prettyPrint();

        // Assert Response message
        //String message= response.jsonPath().get("message");
        //Assert.assertEquals(message,"Order not found");


    }


}
