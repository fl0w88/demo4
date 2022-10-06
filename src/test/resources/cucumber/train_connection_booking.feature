Feature: Book a journey

  Scenario: I want to book a journey
    Given I am using chrome
    And I am on the OEBB Ticketshop homepage
    When I search for a journey from Wien Hbf (U) to Salzburg Hbf
    And I click on the find connections button
    Then I receive a valid result list


