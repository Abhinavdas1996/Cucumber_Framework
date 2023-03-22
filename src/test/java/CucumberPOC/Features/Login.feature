Feature: Application Login

  Scenario: Home page login
    Given User is on commercial website landing page
    Given User is on Banking website landing page
    When User login into application with username "Shyam" and password "Yummy@1234"
    Then User land onto Homepage of the application
    And Grocery items are displayed
    But Error came "True"




  Scenario: Home page login
    Given User is on commercial website landing page
    Given User is on Banking website landing page
    When User login into application with username "Ram" and password "Test@123"
    Then User land onto Homepage of the application
    And Grocery items are displayed
    But Error came "False"