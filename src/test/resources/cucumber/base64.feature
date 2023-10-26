Feature: Encode base 64

  Scenario Outline: Encode base64 <toEncode>
    Given I am on the base64 homepage
    # continue here

    Examples:
      | toEncode | expectedResult |
      | test123  | dGVzdDEyMw==   |