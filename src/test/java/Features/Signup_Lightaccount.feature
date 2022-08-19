Feature: As an user I want to register a Light account

  @test2
  Scenario Outline: Register a Light account
    Given I go to the Idloom page
    When I click on Signup button
    And I select Account type is Light
    And I input Firstname "<firstName>"
    And I input Lastname "<lastName>"
    And I input Email address "<emailAddress>"
    And I input Password "<Password>"
    And I input Confirm password "<confirmPassword>"
    And I input Company name "<companyName>"
    And I input Company address "<companyAddress>"
    And I input Postcode "<Postcode>"
    And I input VAT "<Vat>"
    And I input Phone "<Phone>"
    And I input Referral Code "<referralCode>"
    And I checked I accept checkbox
    And I click on Got it button
    And I click on the button
    Then I go to Congratulations page

    Examples:
      | firstName | lastName   | emailAddress        | Password    | confirmPassword | companyName | companyAddress      | Postcode | Vat   | Phone   | referralCode |
      | An1       | Vo1        | mail1@mailinator.com| P@ssword123 | P@ssword123     | ancompany22 | 106 Nguyen Van Troi | 084      |  BE22 | 12345678| 123          |
