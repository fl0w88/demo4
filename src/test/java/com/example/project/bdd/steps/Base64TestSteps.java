package com.example.project.bdd.steps;

import com.example.project.data.Base64DataProvider;
import com.example.project.helper.TestCaseBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Base64;

public class Base64TestSteps extends TestCaseBase {

    // Base64DataProvider franz = new Base64DataProvider();
    // String textToEncode = franz.getTestData().getText();
    String result = null;

    @Given("^I am on the base64 homepage$")
    public void openPage() {
        b64App().base64Keywords().openBase64Site();
    }

    @And("^I accept the cookie policy$")
    public void closeCookies() {
        b64App().base64Keywords().closeCookies();
    }

    @When("^I enter a (.+) to encode$")
    public void enterData(String textToEncode) {
        result = b64App().base64Keywords().encodeText(textToEncode);
    }

    @Then("^I receive a valid (.+)$")
    public void checkResults(String resultToExpect) {
        Assertions.assertEquals(resultToExpect, result);
        // b64App().base64Keywords().close();
    }
}
