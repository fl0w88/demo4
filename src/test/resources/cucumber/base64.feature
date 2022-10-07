Feature: Encode base 64

  Scenario Outline: Encode base64 <toEncode>
    Given I am on the base64 homepage
    And I accept the cookie policy
    When I enter a <toEncode> to encode
    Then I receive a valid <result>

    Examples:
      | toEncode | result |
      | abc      | YWJj   |