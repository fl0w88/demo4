package com.example.project.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public final class Waiter {

    private Waiter() {
        // this is blank
    }

    public static WebElement wait(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return wait.until(visibilityOfElementLocated(by));
    }

    public static void wait1s() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // noop
        }
    }
}
