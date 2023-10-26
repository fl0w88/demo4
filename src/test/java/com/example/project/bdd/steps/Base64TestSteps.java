package com.example.project.bdd.steps;

import com.example.project.helper.TestCaseBase;
import com.example.project.keywords.Base64App;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

public class Base64TestSteps  {
    private final Base64App base64App = new Base64App();
    @After
    public void tearDown() {
        base64App.base64Keywords().close();
    }

    @Given("^I am on the base64 homepage$")
    public void openPage() {
        base64App.base64Keywords().openBase64Site();
    }

    // TODO: continue here

}
