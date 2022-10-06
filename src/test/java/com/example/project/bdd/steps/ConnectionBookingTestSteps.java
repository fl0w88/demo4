package com.example.project.bdd.steps;

import com.example.project.helper.Waiter;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectionBookingTestSteps {

    private Waiter waiter;
    private WebDriver driver;

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^I am using chrome$")
    public void configureChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        waiter = new Waiter();
    }

    @And("^I am on the OEBB Ticketshop homepage$")
    public void goToOebbHomepage() {
        driver.get("https://shop.oebbtickets.at/en/ticket");
    }

    @And("^I search for a journey from (.+) to (.+)$")
    public void searchForJourney(String departure, String arrival) {
       // TO DO
    }

    @When("^I click on the find connections button$")
    public void clickButton() {
        // TO DO
    }

    @Then("^I receive a valid result list$")
    public void checkResult() {
        // TO DO
    }

}
