package com.example.project.keywords;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Base64Keywords {

    private static WebDriver driver;
    private static WebDriverWait wait = null;

    private void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void close() {
        driver.close();
    }

    public Base64Keywords() {
        super();
    }

    public void openBase64Site() {
        init();
        driver.get("https://www.base64encode.org/");
    }

    public void closeCookies() {
        By inputFrom = By.xpath("//button/span[text() = 'AGREE']");
        wait.until(elementToBeClickable(inputFrom));
        WebElement element = driver.findElement(inputFrom);
        element.click();
        waitALittle();
    }

    public String encodeText(String text) {
        By inputFrom = By.id("input");
        wait.until(elementToBeClickable(inputFrom));
        WebElement element = driver.findElement(inputFrom);
        element.sendKeys(text);

        By buttonSubmitBy = By.id("submit_text");
        wait.until(elementToBeClickable(buttonSubmitBy));
        element = driver.findElement(buttonSubmitBy);
        element.sendKeys(Keys.ENTER);
        waitALittle();

        By output = By.id("output");
        wait.until(elementToBeClickable(output));
        element = driver.findElement(output);
        return element.getText();
    }

    public static void waitALittle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
