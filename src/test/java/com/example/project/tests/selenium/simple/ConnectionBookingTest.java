package com.example.project.tests.selenium.simple;

import com.example.project.helper.Waiter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectionBookingTest {

    private WebDriver driver;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBookConnection() {
        driver.get("https://shop.oebbtickets.at/en/ticket");

        // enter start / destination
        By by = By.xpath("//input[contains(@data-unique-id, 'travelStationFromInput')]");
        WebElement element = Waiter.wait(driver, by);
        element.sendKeys("Wien Hbf (U)");
        Waiter.wait1s();
        element.sendKeys(Keys.ENTER);

        // 1. TODO: überprüfe den Titel der Seite mit Assertions.assertEquals(...)
        // Tipp: Offizielle Selenium Doku ist hier:
        // https://www.selenium.dev/documentation/webdriver/getting_started/first_script/


        // 2. TODO: prüfe ob es gültige Verbindungen/Ergebnisse gibt nach Salzburg

    }

}
