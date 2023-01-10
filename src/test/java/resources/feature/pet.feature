Feature: Testing different request on the pet information

  Scenario: Check if the pet information can be accessed by users
    When User sends a GET request to petID endpoint
    Then User must get back a valid status code 200

  Scenario Outline: Create a new pet & verify if the pet is added
    When I create a new pat by providing the information id "<id>" category "<category>" name "<name>" photoUrls "<photoUrls>" tags "<tags>" status "<status>"
    Then I verify that the pet with "<petID>" is created
    Examples:
      | id | category | name | photoUrls | tags | status    | petID |
      | 1  |          | tom  |           |      | available | 11    |

