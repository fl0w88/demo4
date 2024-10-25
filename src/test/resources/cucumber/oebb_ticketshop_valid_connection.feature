Feature: Book a journey

  Scenario Outline: I want to book a journey from <startStation> to <destinationStation>
    Given I am using chrome
    And I am on the OEBB Ticketshop homepage
    When I search for a journey from <startStation> to <destinationStation>
    Then I receive a valid connection

    Examples:
      | startStation | destinationStation |
      | Wien Hbf (U) | Salzburg Hbf       |
      | Wien Hbf (U) | Graz               |

