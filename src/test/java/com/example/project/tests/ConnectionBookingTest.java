package com.example.project.tests;

import com.example.project.helper.Waiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
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
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBookConnection() {
        driver.get("https://shop.oebbtickets.at/en/ticket");
        Waiter waiter = new Waiter();

        By by = By.xpath("//input[contains(@data-unique-id, 'travelStationFromInput')]");
        WebElement element = waiter.wait(driver, by);
        element.sendKeys("Wien Hbf (U)");
        waiter.wait1s();
        element.sendKeys(Keys.ENTER);

        by = By.xpath("//input[contains(@data-unique-id, 'travelStationToInput')]");
        element = waiter.wait(driver, by);
        element.sendKeys("Salzburg");
        waiter.wait1s();
        element.sendKeys(Keys.ENTER);

        by = By.xpath("//button[contains(@data-unique-id, 'travelFindServicesSplitButton')]");
        element = waiter.wait(driver, by);
        element.click();

        by = By.xpath("//button[contains(@data-unique-id, 'timetable')]");
        element = waiter.wait(driver, by);
        element.click();

        // verify a timetable is returned
        by = By.xpath("//timetable-connection");
        waiter.wait(driver, by);
    }

}
