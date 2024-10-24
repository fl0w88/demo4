# Demo4

## Selenium Example

* Run the [ConnectionBookingTest](src/test/java/com/example/project/tests/selenium/simple/ConnectionBookingTest.java) to
  get a feeling of how Selenium works

## Test Automation Framework Example

This project has a very abstract and lightweight structure of what test automation frameworks could look like
(extremely light and abstract), but it should give you an idea.

* [Base64Test](src/test/java/com/example/project/tests/taf/Base64Test.java) should give you a rough idea of how keywords
  can be combined in a test case

## Tasks

1. Run the [ConnectionBookingTest](src/test/java/com/example/project/tests/selenium/simple/ConnectionBookingTest.java)
   and extend it by a title check: verify that the title of the page is "Tickets & Services"
2. Implement the same test via BDD [oebb_ticketshop_valid_page_title.feature](src/test/resources/cucumber/oebb_ticketshop_valid_page_title.feature)
3. Perform the train connection booking via
   BDD/Cucumber: [oebb_ticketshop_valid_connection.feature](src/test/resources/cucumber/oebb_ticketshop_valid_connection.feature)
   (hint: fill
   out [ConnectionBookingTestSteps](src/test/java/com/example/project/bdd/steps/ConnectionBookingTestSteps.java))
4. Transform the test case into a scenario outline with 2 different destinations
5. Adapt the Base64Test to use data from
   the [Base64DataProvider](src/main/java/com/example/project/data/Base64DataProvider.java)
6. Perform the Base64 keywords test via Cucumber
7. Extend the Base64 keywords & cucumber tests to verify base64 decoding 
8. Extend the connection booking test case until payment
