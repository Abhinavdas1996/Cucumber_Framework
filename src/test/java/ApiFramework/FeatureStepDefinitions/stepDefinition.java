package ApiFramework.FeatureStepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.ApiResources;
import resources.TestData;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class stepDefinition extends Utils {


    RequestSpecification request;

    Response response;
    Response res;
    ApiResources apiResourceObj;
    static String placeID;

    TestData td = new TestData();

    @Given("Add place payload with {string}   {double}   {string}  {string}    {int}")
    public void add_place_payload_with(String name, Double latitude, String phoneNumber, String language, Integer accuracy) throws IOException {


        //Request info
        request = given().log().all().spec(requestCommonUtility())
                .body(td.requestPayload(name, latitude, phoneNumber, language, accuracy));


    }

    @When("User call {string} using {string} http method")
    public void User_call_AddPlaceApi_using_Post_http_method(String resource, String httpMethod) {


        apiResourceObj = ApiResources.valueOf(resource);
        System.out.println(apiResourceObj.getResource());


        if (httpMethod.equalsIgnoreCase("POST")) {

            //Hit the request by using http method
            response = request.when().post(apiResourceObj.getResource());


        } else if (httpMethod.equalsIgnoreCase("GET")) {

            //Hit the request by using http method
            response = request.when().get(apiResourceObj.getResource());

        }

    }


    @Then("API call got success message with status code 200")
    public void API_call_got_success_message_with_200_status_code() {

        res = response.then().assertThat().log().all().spec(responseCommonUtility()).extract().response();

        Assert.assertEquals(200, res.getStatusCode());
    }


    @Then("{string} in response body is {string}")
    public void responseBody(String keyValue, String ExpValue) {


        Assert.assertEquals(ExpValue, getJsonPath(response, keyValue));

    }


    @And("Verify {string} against place_id using {string}")
    public void verify_against_place_id_using(String expectedName, String resource) throws IOException {

        //Prepare request spec and hit the get api

        placeID = getJsonPath(response, "place_id");
        request = given().spec(requestCommonUtility()).queryParams("place_id", placeID);

        User_call_AddPlaceApi_using_Post_http_method(resource, "GET");


        String actualName = getJsonPath(response, "name");

        Assert.assertEquals(expectedName, actualName);

    }


    @Given("Create request with delete place payload")
    public void create_request_with_delete_place_payload() throws IOException {

        request = given().spec(requestCommonUtility()).body(td.deletePlaceAPI(placeID));

    }
}
