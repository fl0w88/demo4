Feature: Encode base 64

  Scenario Outline: Encode base64 <toEncode>
    Given I am on the base64 homepage
    And I accept the cookies
    When I enter data to <toEncode>
    And I push the encode button
    Then I receive the result <expectedResult>

    Examples:
      | toEncode | expectedResult |
      | test123  | dGVzdDEyMw==   |