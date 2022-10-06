package com.example.project.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Waiter {

    public WebElement wait(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(elementToBeClickable(by));
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            // noop
        }
        return element;
    }

    public void wait1s() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // noop
        }
    }
}
