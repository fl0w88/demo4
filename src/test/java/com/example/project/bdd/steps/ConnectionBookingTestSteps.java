package com.example.project.bdd.steps;

import com.example.project.helper.Waiter;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        // enter start / destination
        By by = By.xpath("//input[contains(@data-unique-id, 'travelStationFromInput')]");
        WebElement element = waiter.wait(driver, by);
        element.sendKeys(departure);
        waiter.wait1s();
        element.sendKeys(Keys.ENTER);

        by = By.xpath("//input[contains(@data-unique-id, 'travelStationToInput')]");
        element = waiter.wait(driver, by);
        element.sendKeys(arrival);
        waiter.wait1s();
        element.sendKeys(Keys.ENTER);
    }

    @When("^I click on the find connections button$")
    public void clickButton() {
        By by = By.xpath("//button[contains(@data-unique-id, 'travelFindServicesSplitButton')]");
        WebElement element = waiter.wait(driver, by);
        element.click();

        by = By.xpath("//button[contains(@data-unique-id, 'timetable')]");
        element = waiter.wait(driver, by);
        element.click();
    }

    @Then("^I receive a valid result list$")
    public void checkResult() {
        // verify if a valid timetable is returned
        By by = By.xpath("//timetable-connection");
        waiter.wait(driver, by);
    }

    @Then("^I receive a valid title$")
    public void checkTitle() {
        // wait for page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        Assertions.assertEquals("Tickets and Services", driver.getTitle());
    }

}
