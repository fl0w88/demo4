package com.example.project.bdd.steps;

import com.example.project.keywords.Base64App;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Base64TestSteps  {

    private final Base64App base64App = new Base64App();
    String operationResult;

    @After
    public void tearDown() {
        // base64App.base64Keywords().close();
    }

    @Given("^I am on the base64 homepage$")
    public void openPage() {
        base64App.base64Keywords().openBase64Site();
    }

    @And("^I accept the cookies$")
    public void acceptCookies() {
        base64App.base64Keywords().closeCookies();
    }

    @When("^I enter data to (.*)$")
    public void enterData(String dataToEncode) {
        operationResult = base64App.base64Keywords().encodeText(dataToEncode);
    }

    @Then("^I receive the result (.*)$")
    public void checkResult(String expectedResult) {
        Assertions.assertEquals(expectedResult, operationResult);
    }

    @And("^I push the encode button$")
    public void pushEncodeButton() {
        //
    }


}
