Feature: Testing different request on the user application


  Scenario Outline: Create a new user & verify if the user is added
    When I create a new user by providing the information id "<id>" username "<userName>" firstName "<firstName>" lastName "<lastName>" email "<email>"password"<password>"phone"<phone>"userStatus"<userStatus>"
    Then I verify that the student with "<userName>" is created
    Examples:
      | id  | userName | firstName | lastName | email            | password | phone       | userStatus |
      | 101 | Testing  | software  | selenium | prime1@gmail.com | Tomtpom  | 08765434677 | 0          |
