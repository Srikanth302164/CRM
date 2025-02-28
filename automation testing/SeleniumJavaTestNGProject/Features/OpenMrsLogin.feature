Feature: OpenMrs Login feature
  Background: 
    Given Launch OpenMRs Login Page
    
    @LoginWithValidCredentials
    Scenario: verify Login with valid Credentials
    Given User is on OpenMrs Login Page
    When User logins with Username "ABCD123" and password "ABCD123"
    And Clicks Login button
    Then Login should Successfull

    Scenario: verify Login with invalid Credentials
    Given User is on OpenMrs Login Page
    When User logins with Username "ABCD@123" and password "ABCD@123"
    And Clicks Login button
    Then Login should fail

    Scenario Outline: Verify Login with multiple sets of users
    Given User is on OpenMrs Login Page
    When User logins with Username <"Username"> and password <"Password">
    And Clicks Login button
    Then Login should Successfull

    Examples: 
      | Username | Password |
      | ABCD123  | ABCD123  |
      | BCDE123  | BCDE123  |
      | CDEF123  | CDEF123  |



  