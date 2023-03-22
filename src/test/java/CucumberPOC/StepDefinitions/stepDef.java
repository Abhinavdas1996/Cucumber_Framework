package CucumberPOC.StepDefinitions;

import io.cucumber.java.en.*;


public class stepDef {

    @Given("User is on commercial website landing page")
    public void User_is_on_commercial_website_landing_page() {

        System.out.println("Navigated to commercial website landing page");

    }

    @Given("User is on Banking website landing page")
    public void User_is_on_Banking_website_landing_page(){

        System.out.println("Navigated to Banking website landing page");
    }

    @When("User login into application with username {string} and password {string}")
    public void User_login_into_application_with_username_and_password(String uname, String pwd){

        System.out.println("Entered username and password");
        System.out.println("Username= "+uname+ " and Password= "+pwd);
    }

    @Then("User land onto Homepage of the application")
    public void User_land_onto_Homepage_of_the_application(){

        System.out.println("Navigated to Website home page");
    }

    @And("Grocery items are displayed")
    public void Grocery_items_are_displayed(){

        System.out.println("Successfully! Grocery items are displayed. Thank you for demo.");
    }

    @But("Error came {string}")
    public void Error_came(String ans){
        System.out.println("Unfortunately, Error triggered?: "+ans);
        System.out.println("\n=========================\n");
    }

}
