Feature: As an user I want to register an account from the website

  @test
  Scenario Outline: Register a valid account for the first page
    Given The website is showed
    When User input valid Firstname "<Firstname>"
    And User input valid Lastname "<Lastname>"
    And User input valid Username "<Username>"
    And User input valid Password "<Password>"
    And User input valid Confirm "<Confirm>"
    And User click on Next button
    Then Verify your fone number page is showed
    When User input valid Phonenumber "<Phonenumber>"
    And User click on Next button again
    Then The third page is showed

    Examples:
      | Firstname | Lastname | Username      | Password    | Confirm      | Phonenumber |
      | An6       | Vo6      | Antes7896     | P@ssword789 | P@ssword789  | 1234567890  |
      | An7       | Vo7      | Antes7897     | P@ssword789 | P@ssword789  | 1234567890  |


