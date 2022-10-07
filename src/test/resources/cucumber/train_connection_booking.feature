Feature: Book a journey

  @OEBB-15
  Scenario Outline: I want to book a journey from <startStation> to <destinationStation>
    Given I am using chrome
    And I am on the OEBB Ticketshop homepage
    When I search for a journey from <startStation> to <destinationStation>
    And I click on the find connections button
    Then I receive a valid result list

    Examples:
      | startStation | destinationStation |
      | Wien Hbf (U) | Salzburg Hbf       |
      | Wien Hbf (U) | Graz               |

