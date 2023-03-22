package ApiFramework.FeatureStepDefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {


    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        stepDefinition sd = new stepDefinition();

        if (stepDefinition.placeID ==null) {

            sd.add_place_payload_with("Rajat", 405.2, "8758758472", "Nepali", 50);
            sd.User_call_AddPlaceApi_using_Post_http_method("AddPlaceApi", "POST");
            sd.verify_against_place_id_using("Rajat", "GetPlaceApi");
        }
    }
}
