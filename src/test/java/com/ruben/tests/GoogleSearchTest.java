package com.ruben.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeEach
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testGoogleSearch(){
        driver.get("https://www.google.com");

        try{
            driver.findElement(By.xpath("//button//*[contains(text(),'Accept') or contains(text(),'I agree')]/..")).click();
        }catch(Exception ignored){
            System.out.println(driver.getCurrentUrl());
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Test Automation Selenium");
        searchBox.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

        assertTrue(driver.getCurrentUrl().contains("search"),
                "Expected URL to contain 'search', but was: " + driver.getCurrentUrl());

        int resultsCount = driver.findElements(By.cssSelector("#search .g")).size();
        assertTrue(resultsCount > 0, "Expected at least 1 result, but found: " + resultsCount);
    }

    @AfterEach
    void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
