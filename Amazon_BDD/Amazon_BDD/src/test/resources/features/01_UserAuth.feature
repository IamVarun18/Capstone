Feature: User Login and Registration

  Scenario Outline: Register new user with valid data
    Given user is on the registration page using <email>
    When user enters valid <email>, <fullName> and <password>
    Then a new account should be created

    Examples: 
      | fullName | email                      | password    |
      | "Varun Vishwakarma"  | "example.018072001@gmail.com" | "Test@1234" |

  Scenario Outline: Login with valid credentials
    Given user is on the login page
    When user enters valid <email> and <password>
    And user enters otp recieved on mobile number
    Then user should be logged in successfully

    Examples: 
      | email                      | password     |
      | "varun.018072001@gmail.com" | "Varun@018072001" |

  Scenario Outline: Login with invalid credentials
    Given user is on the login page
    When user enters invalid <email> and <password>
    Then shows an error message

    Examples: 
      | email                      | password     |
      | "varun.018072001@gmail.com" | "7874585235" |

  Scenario Outline: Logout from account
    Given user is logged in as <email> and <password>
    When user clicks on Sign Out <email> and <password>
    Then user should be redirected to home page

    Examples: 
      | email                      | password     |
      | "varun.018072001@gmail.com" | "Varun@018072001" |
