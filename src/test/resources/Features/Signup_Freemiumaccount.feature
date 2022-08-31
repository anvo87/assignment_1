Feature: As an user I want to register a Freemium account

  @test1
  Scenario Outline: Register a Freemium account
    Given I go to the Idloom page
    When I click on Signup button
    And I input Firstname "<firstName>"
    And I input Lastname "<lastName>"
    And I input Email address "<emailAddress>"
    And I input Password "<Password>"
    And I input Confirm password "<confirmPassword>"
    And I input Company name "<companyName>"
    And I input Phone "<Phone>"
    And I checked I accept checkbox
    And I click on Got it button
    And I click on the button
    Then I go to Congratulations page
    And I click on Login button
    And I input Username "<emailAddress>"
    And I input Password for Login page "<Password>"
    And I click on Sign In button


    Examples:
    | firstName | lastName   | emailAddress        | Password    | confirmPassword | companyName | Phone   |
    | An1       | Vo1        | mail12@mailinator.com| P@ssword123 | P@ssword123     | ancompany35  | 12345678|
    | An2       | Vo2        | mail13@mailinator.com| P@ssword123 | P@ssword123     | ancompany36 | 12345678|


