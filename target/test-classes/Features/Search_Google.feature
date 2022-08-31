Feature: I want to search a key on Google page

  @test3
  Scenario Outline: Search a key and compare the first result
    Given I go to Google page
    When I input a keyword "<keyword>"
    And I type enter
    Then I verify the first result has "<keyword>"

    Examples:
    | keyword |
    | antest  |

  @test4
  Scenario Outline: Search a key and compare the suggestion list
    Given I go to Google page
    When I input a keyword "<keyword>"
    Then I select the first item on the suggestion list
    And I verify the first result has "<keyword>"

    Examples:
      | keyword |
      | antest  |

    @test5
    Scenario: Verify Google Search button exists
      Given I go to Google page
      Then I verify Google Search button exists
