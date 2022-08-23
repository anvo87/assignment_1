Feature: As an user I want to register a demo account

  @test2
  Scenario Outline: Register a demo account
    Given I go to the Idloom page
    When I click on Signup button
    And I select Account type is demo
    And I input Fullname "<fullName>"
    And I input Email address "<emailAddress>"
    And I input Company name "<companyName>"
    And I input Phone "<Phone>"
    And I checked I accept checkbox
    And I click on Got it button
    And I click on the button
    Then I go to Thank you page


      Examples:
      | fullName  | emailAddress        | companyName | Phone   |
      | An1       | mail1@mailinator.com| ancompany25  | 12345678|