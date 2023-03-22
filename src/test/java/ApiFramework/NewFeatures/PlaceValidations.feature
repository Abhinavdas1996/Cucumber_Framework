Feature: Validate the place API
@AddPlace
  Scenario Outline: Verify if user able to add place using AddPlace api
    Given Add place payload with "<name>"   <lat>   "<phone_number>"  "<language>"    <accuracy>
    When User call "AddPlaceApi" using "Post" http method
    Then API call got success message with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify "<name>" against place_id using "GetPlaceApi"


    Examples:

      | name       | lat     | phone_number | language | accuracy |
      | Aman       | 301.74  | 8130950235   | Hindi    | 20       |
#      | Raju Singh | 3322.74 | 8133340234   | English  | 70       |


@DeletePlace
    Scenario: Verify if delete place functionality working correctly
      Given Create request with delete place payload
      When User call "DeletePlaceApi" using "Post" http method
      Then API call got success message with status code 200
      And "status" in response body is "OK"
