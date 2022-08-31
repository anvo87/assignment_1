Feature: I want to calculate two numbers

  @test6
  Scenario Outline: Add any two numbers
    When I go to Calculator page
    And I select first number "<number1>"
    And I select calculate "<calculate>"
    And I select second number "<number2>"
    And I select equal
    Then I verify the result equal "<result>"

    Examples:
    | number1  | number2  | calculate | result |
    | 1222     | 34       |  Plus     | 1256   |
    | 55       | 13       |  Minus    | 42     |
    | 10       | 5        |  Mult     | 50     |
    | 12       | 4        |  Div      | 3      |

