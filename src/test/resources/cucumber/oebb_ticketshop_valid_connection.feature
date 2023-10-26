Feature: Book a journey

  Scenario Outline: I want to book a journey from <startStation> to <destinationStation>
    Given I am using chrome
    And I am on the OEBB Ticketshop homepage
    # continue from here

    Examples:
      | startStation | destinationStation |
      | Wien Hbf (U) | Salzburg Hbf       |
      | Wien Hbf (U) | Graz               |

