Feature: CRUD Operation on Jsonplaceholder application

  Scenario: Get all posts
    Given I have a base URI of "https://api.vschool.io/%5byour_name%5d/todo/"
    When I send a GET request to "/"
    Then the response status code should be 200

  Scenario Outline: Create post
    Given I have a base URI of "https://api.vschool.io/%5byour_name%5d/todo/"
    When I send a POST request to "/" with body as "<RequestBody>"
    Then the response time less than 5000

    Examples: 
      | RequestBody                                                                                                 |
      | { \\"title\\": \\"Buy Milk\\", \\"description\\": \\"2 Litres\\", \\"price\\": 40, \\"completed\\": false } |

  Scenario Outline: Update the same post using Id
    Given I have a base URI of "https://api.vschool.io/%5byour_name%5d/todo/"
    When I send a PUT request to "/<Id>" with body as "<RequestBody>"
    Then the response body should contain "Buy Milk Updated"

    Examples: 
      | RequestBody                                                                                                          |
      | { \\"title\\": \\"Buy Milk Updated\\", \\"description\\": \\"Full Cream\\", \\"price\\": 50, \\"completed\\": true } |

  Scenario: Delete the post using Id
    Given I have a base URI of "https://api.vschool.io/%5byour_name%5d/todo/"
    When I send a DELETE request to "/6643af841cfabf03c4d12345"
    Then the response header "Content-Type" should be "application/json; charset=utf-8"
 