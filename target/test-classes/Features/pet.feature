
@ApiPetStore
@regression
@smoke
Feature: Tests de syntaxes pour l'objet PET du swagger


  Scenario: GET pet


    Given user naviagte to the "https://petstore.swagger.io/v2/pet/2" api end point
     And user verifies header in response body
    And user verifies status code is 200
    Then user verifies contet type is  "application/json"



  Scenario: POST pet


    When user naviagte to the "https://petstore.swagger.io/v2/pet" api end point.
    And user sets the request body
    And  user verifies name is created in response body


  Scenario: DELETE pet
    When user naviagte to the delete "https://petstore.swagger.io/v2/pet/9" api end point..
    And user verifies response message
