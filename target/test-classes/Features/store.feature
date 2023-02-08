
@ApiPetStore
@regression
@smoke
Feature: store
  Objective: Check that stock is available for the purchase of pets


  Scenario: Create one e2e test for petStore

  Given user send the request body  "https://petstore.swagger.io/v2/store/order"  end point
    When user sends pet ID  in string format to request body
  Then  user validates response code is 200
  Then user verifies with order ID created stock is available
  Then user verifies that response contains pet ID and Status
  Then user delete created petStore
  And user verifies status code of deleted petStore
#  Then user verifies with GET request if petStore is deleted



