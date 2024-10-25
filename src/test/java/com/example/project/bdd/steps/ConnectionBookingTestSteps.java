package com.example.project.bdd.steps;

import com.example.project.helper.Waiter;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectionBookingTestSteps {

    private Waiter waiter;
    private WebDriver driver;

    @After
    public void tearDown() {
        if (driver != null) {
           // driver.quit();
        }
    }

    @Given("^I am using chrome$")
    public void configureChrome() {
        driver = new ChromeDriver();
    }

    @And("^I am on the OEBB Ticketshop homepage$")
    public void goToOEBBHomepage() {
        driver.get("https://shop.oebbtickets.at/en/ticket");
    }

    @And("^I search for a journey from (.+) to (.+)$")
    public void searchForJourney(String departureStation, String arrivalStation) {
        // enter start / destination
        By by = By.xpath("//input[contains(@data-unique-id, 'travelStationFromInput')]");
        WebElement element = Waiter.wait(driver, by);
        element.sendKeys(departureStation);
        Waiter.wait1s();
        element.sendKeys(Keys.ENTER);

        by = By.xpath("//input[contains(@data-unique-id, 'travelStationToInput')]");
        element = Waiter.wait(driver, by);
        element.sendKeys(arrivalStation);
        Waiter.wait1s();
        element.sendKeys(Keys.ENTER);

        by = By.xpath("//button[contains(@data-unique-id, 'travelFindServicesSplitButton')]");
        element = Waiter.wait(driver, by);
        element.click();
    }

    @Then("^I receive a valid connection$")
    public void checkValidConnection() {
        By by = By.xpath("(//button[contains(@id, 'connection-button')])[2]");
        WebElement element = Waiter.wait(driver, by);
        element.click();

        by = By.xpath("//offer-block");
        element = Waiter.wait(driver, by);
    }

    @Then("^I receive a valid title$")
    public void checkTitle() {
        // prüfe titel der seite
        Assertions.assertNotNull(driver.getTitle());
    }

}
